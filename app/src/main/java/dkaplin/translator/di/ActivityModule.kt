package dkaplin.translator.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dkaplin.translator.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
