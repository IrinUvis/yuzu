package uvis.irin.yuzu

import android.app.Application
import org.koin.core.context.startKoin
import uvis.irin.yuzu.di.yuzuModule

class YuzuApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(yuzuModule)
        }
    }
}
