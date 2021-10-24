package prussian.project.kode_tz.super_heroes.api.json.get

import kotlinx.serialization.Serializable

@Serializable
data class Work(
    val base: String,
    val occupation: String
) {
    override fun toString(): String {
        return  "Base:\n\"$base\"\n\n" +
                "Occupation:\n\"$occupation\""
    }
}