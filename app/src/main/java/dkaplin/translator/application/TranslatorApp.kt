package dkaplin.translator.application

import android.app.Application
import dkaplin.translator.di.application
import dkaplin.translator.di.historyScreen
import dkaplin.translator.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
