package prussian.project.kode_tz.super_heroes.ui.fragment.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import prussian.project.kode_tz.super_heroes.R
import prussian.project.kode_tz.super_heroes.api.json.get.AllInfo
import prussian.project.kode_tz.super_heroes.ui.fragment.biography.Bio
import prussian.project.kode_tz.super_heroes.ui.fragment.biography.Drawable

class MenuAdapter(
    private val list: List<AllInfo>,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgHero: ImageView = itemView.findViewById(R.id.imgHero)
         val txtHeroName: TextView = itemView.findViewById(R.id.txtHeroName)
        val txtHeroRealName: TextView = itemView.findViewById(R.id.txtHeroRealName)
        val imgStudio: ImageView = itemView.findViewById(R.id.imgStudio)

    }

    /*   инициализация  layout   */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
             LayoutInflater.from(parent.context).inflate(
                R.layout.item_hero_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderMenu: MenuViewHolder, position: Int) {
        holderMenu.itemView.rootView.setOnClickListener {
            val data = list[position]
                itemClickListener.onItemClick(
                Bio(
                    Drawable(holderMenu.imgHero.drawable),
                    data.name, data.biography.fullName,
                    "${data.powerstats}\n\n" +
                            "${data.biography}\n\n" +
                            "${data.appearance}\n\n" +
                            "${data.connections}\n\n" +
                            "${data.work}",
                    Drawable(holderMenu.imgStudio.drawable)
                )
            )
        }

        /*   Картинка героя   */
        Glide.with(holderMenu.itemView)
            .load(list[position].images.lg)
            .into(holderMenu.imgHero)

        /*   установка текста   */
        holderMenu.txtHeroName.text = list[position].name
        holderMenu.txtHeroRealName.text = list[position].biography.fullName

        /*   установка лого комиксов    */
        when (list[position].biography.publisher) {
            "Marvel Comics" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_marvel_logo)
            "Dark Horse Comics" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_dark_horse_comics_logo)
            "DC Comics" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_dc_comics_logo)
//            "NBC - Heroes" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Wildstorm" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Archangel" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Tempest" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Giant-Man" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Toxin" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Angel" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Goliath" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Oracle" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Spoiler" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Nightwing" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Icon Comics" -> holderMenu.imgStudio.setImageResource(R.drawable.)
            "SyFy" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_syfy)
//            "George Lucas" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Meltdown" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Gemini V" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "South Park" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Binary" -> holderMenu.imgStudio.setImageResource(R.drawable.)
            "ABC Studios" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_abc_studios_logo)
            "Universal Studios" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_universal_studios)
            "Star Trek" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_star_trek)
//            "Evil Deadpool" -> holderMenu.imgStudio.setImageResource(R.drawable.)
            "IDW Publishing" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_idw_publishing)
//            "Deadpool" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Black Racer" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Speed Demon" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Impulse" -> holderMenu.imgStudio.setImageResource(R.drawable.)
            "Shueisha" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_sh_eisha_logo)
            "Sony Pictures" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_sony_pictures_logo)
//            "J. K. Rowling" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Batgirl III" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Flash IV" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Titan Books" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Phoenix" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Power Woman" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Rebellion" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Iron Lad" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Power Man" -> holderMenu.imgStudio.setImageResource(R.drawable.)
            "Image Comics" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_comics_logo)
            "Microsoft" -> holderMenu.imgStudio.setImageResource(R.drawable.ic_microsoft_logo)
//            "Boom-Boom" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Batgirl V" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "She-Thing" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Batman II" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Batgirl" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Jean Grey" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Robin II" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Robin III" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Red Hood" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Red Robin" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "J. R. R. Tolkien" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Spider-Carnage" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Venom III" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Ms Marvel II" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Aztar" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Superman Prime One-Million" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Angel Salvadore" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Rune King Thor" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Anti-Venom" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Scorpion" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Vindicator II" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Anti-Vision" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Thunderbird II" -> holderMenu.imgStudio.setImageResource(R.drawable.)
//            "Ant-Man" -> holderMenu.imgStudio.setImageResource(R.drawable.)
            else -> holderMenu.imgStudio.setImageResource(android.R.drawable.ic_delete)
        }
    }
      override fun getItemCount() = list.size
 }
