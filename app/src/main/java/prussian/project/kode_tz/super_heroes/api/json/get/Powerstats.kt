package prussian.project.kode_tz.super_heroes.api.json.get

import kotlinx.serialization.Serializable

@Serializable
data class Powerstats(
    val combat: Int,
    val durability: Int,
    val intelligence: Int,
    val power: Int,
    val speed: Int,
    val strength: Int
) {
    override fun toString(): String {
        return  "Power stats:\n\n" +
                "Combat: $combat\n" +
                "Durability: $durability\n" +
                "Intelligence: $intelligence\n" +
                "Power: $power\n" +
                "Speed: $speed\n" +
                "Strength: $strength"
    }
}