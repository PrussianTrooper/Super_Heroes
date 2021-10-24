package prussian.project.kode_tz.super_heroes.api.json.get

import kotlinx.serialization.Serializable

@Serializable
data class Images(
    val lg: String,
    val md: String,
    val sm: String,
    val xs: String
)