package prussian.project.kode_tz.super_heroes.api.json.get

import kotlinx.serialization.Serializable

@Serializable
data class Connections(
    val groupAffiliation: String,
    val relatives: String
) {
    override fun toString(): String {
        return  "Group-affiliation:\n\n\"$groupAffiliation\"\n\n" +
                "Relatives:\n\n\"$relatives\""
    }
}