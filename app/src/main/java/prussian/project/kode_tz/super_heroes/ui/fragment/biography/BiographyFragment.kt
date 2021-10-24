package prussian.project.kode_tz.super_heroes.ui.fragment.biography

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import prussian.project.kode_tz.super_heroes.R

class BiographyFragment : Fragment() {

    private val args: BiographyFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*   иакет окна инициализаци  */
        return inflater.inflate(R.layout.fragment_biorgraphy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imgHero: ImageView = view.findViewById(R.id.imgBioHero)
        val txtHeroName: TextView = view.findViewById(R.id.txtHeroBioName)
        val txtHeroRealName: TextView = view.findViewById(R.id.txtHeroBioRealName)
        val imgStudio: ImageView = view.findViewById(R.id.imgBioStudio)
        val txtHeroDescription: TextView = view.findViewById(R.id.txtHeroBioDescription)

        /*   выбор картинки  */
        Glide.with(view)
            .load(args.bio.heroImage.image)
            .into(imgHero)

        /*   выбор картинки  */
        imgStudio.setImageDrawable(args.bio.heroStudioImage.image)

        /*   настройка текста   */
        txtHeroName.text = args.bio.heroName
        txtHeroRealName.text = args.bio.heroRealName
        txtHeroDescription.text = args.bio.heroDescription

        /*   картинка н аполный экран  */
        imgHero.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                BiographyFragmentDirections.actionBiographyFragmentToFullScreenImageFragment(args.bio.heroImage)
            )
        }
    }
}