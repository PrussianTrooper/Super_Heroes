package prussian.project.kode_tz.super_heroes.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import prussian.project.kode_tz.super_heroes.api.SuperHeroAPI
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private const val URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

@ExperimentalSerializationApi
val networkModule = module {
    single { provideOkHttp(get()) }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
}

private fun provideOkHttp(context: Context): OkHttpClient {
    return OkHttpClient.Builder()
        .callTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .cache(Cache(context.cacheDir, 10485760))   // 10 MB кэш
        .followRedirects(true)
        .followSslRedirects(true)        // SSL Support
        .build()
}

@ExperimentalSerializationApi
private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(URL)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()
}

private fun provideApiService(retrofit: Retrofit): SuperHeroAPI {
    return retrofit.create(SuperHeroAPI::class.java)
}