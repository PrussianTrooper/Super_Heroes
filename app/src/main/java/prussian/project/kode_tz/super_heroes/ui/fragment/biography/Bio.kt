package prussian.project.kode_tz.super_heroes.ui.fragment.biography

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bio(
    val heroImage: Drawable,
    val heroName: String,
    val heroRealName: String,
    val heroDescription: String,
    val heroStudioImage: Drawable
) : Parcelable