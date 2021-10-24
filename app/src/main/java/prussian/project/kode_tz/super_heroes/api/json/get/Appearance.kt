package prussian.project.kode_tz.super_heroes.api.json.get

import kotlinx.serialization.Serializable

@Serializable
data class Appearance(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String? = "",
    val weight: List<String>
) {
    override fun toString(): String {
        return  "Eye color: \"$eyeColor\"\n" +
                "Gender: \"$gender\"\n" +
                "Hair color: \"$hairColor\"\n" +
                "Height: ${
                    height.toString()
                    .replace('[', '"')
                    .replace(']', '"')
                }\n" +
                "Race: \"$race\"\n" +
                "Weight: ${
                    weight.toString()
                    .replace('[', '"')
                    .replace(']', '"')
                }"
    }
}