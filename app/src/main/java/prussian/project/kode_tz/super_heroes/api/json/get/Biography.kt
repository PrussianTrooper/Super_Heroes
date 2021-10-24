package prussian.project.kode_tz.super_heroes.api.json.get

import kotlinx.serialization.Serializable

@Serializable
data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String? = ""
) {
    override fun toString(): String {
        return  "Biography:\n\n" +
                "Aliases: ${
                    aliases.toString()
                    .replace('[', '"')
                    .replace(']', '"')
                }\n" +
                "Alignment: \"$alignment\"\n" +
                "Alter egos: \"$alterEgos\"\n" +
                "First appearance: \"$firstAppearance\"\n" +
                "Place of birth: \"$placeOfBirth\"\n" +
                "Publisher: \"$publisher\""
    }
}