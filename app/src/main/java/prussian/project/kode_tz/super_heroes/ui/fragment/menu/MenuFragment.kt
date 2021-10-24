package prussian.project.kode_tz.super_heroes.ui.fragment.menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import prussian.project.kode_tz.super_heroes.R
import prussian.project.kode_tz.super_heroes.api.SuperHeroAPI
import prussian.project.kode_tz.super_heroes.api.json.get.AllInfo
import prussian.project.kode_tz.super_heroes.ui.fragment.biography.Bio

class MenuFragment : Fragment(), ItemClickListener {

    private lateinit var spinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var publisherList: List<String>
    private val service by inject<SuperHeroAPI>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        spinner = view.findViewById(R.id.spinner)
        recyclerView = view.findViewById(R.id.recycler)

        /*   запрос инфы от json  */
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            kotlin.runCatching {
                service.getAllInfo()
            }.onSuccess { result ->
                var all = listOf("All")
                /*   чек издателей   */
                result.forEach {
                  it.biography.publisher?.let { publisher -> if (publisher.isNotBlank())
                            all =all + publisher
                    }
                }
                publisherList =all.toSet().toList()

                /*   выпадающий список(пикер)   */
                spinner.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    publisherList
                )
            }.onFailure {
                Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
              override fun onItemSelected(
                  parent: AdapterView<*>?,
                  view: View?,
                  position: Int,
                  id: Long
            )  {
                /*  инфа JSON   */
                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    kotlin.runCatching {//отлов ошибок
                        service.getAllInfo()
                    }.onSuccess { result ->
                        val filteredList = mutableListOf<AllInfo>()
                        if (parent?.getItemAtPosition(position) == "All"){
                            /*   Добавление героев в список   */
                            filteredList += result
                        }  else {

                            result.forEach { item ->
                                item.biography.publisher?.let {
                                    if (it == parent?.getItemAtPosition(position)) {
                                        filteredList += item
                                    }
                                }
                              }
                         }
                        /*   установка героев в список  */
                        recyclerView.adapter = MenuAdapter(filteredList, this@MenuFragment)
                    }.onFailure {
                        Log.e("Status", it.message.toString())
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    override fun onItemClick(bio: Bio) {

        /*   окно навигации(биография)  */
        Navigation.findNavController(requireView())
            .navigate(
                MenuFragmentDirections.actionMainFragmentToBiographyFragment(bio)
            )
    }
}