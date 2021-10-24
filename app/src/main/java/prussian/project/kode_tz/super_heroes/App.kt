package prussian.project.kode_tz.super_heroes

import android.app.Application
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import prussian.project.kode_tz.super_heroes.di.networkModule
//Загрузка приложения
@ExperimentalSerializationApi
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(networkModule)
        }
    }
}