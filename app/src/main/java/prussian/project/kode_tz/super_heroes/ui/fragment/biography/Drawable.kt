package prussian.project.kode_tz.super_heroes.ui.fragment.biography

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Drawable(val image: @RawValue Drawable) : Parcelable