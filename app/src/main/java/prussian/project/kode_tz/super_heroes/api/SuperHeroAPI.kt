package prussian.project.kode_tz.super_heroes.api

import prussian.project.kode_tz.super_heroes.api.json.get.AllInfo
import retrofit2.http.GET
import java.util.*

interface SuperHeroAPI {
    @GET("all.json")
    suspend fun getAllInfo() : ArrayList<AllInfo>
}