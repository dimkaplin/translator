package dkaplin.translator.di

import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.datasource.RetrofitImplementation
import dkaplin.translator.model.datasource.RoomDataBaseImplementation
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryImplementation
import dkaplin.translator.view.main.MainInteractor
import dkaplin.translator.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<WordModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(RetrofitImplementation()) }
    single<Repository<List<WordModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(RoomDataBaseImplementation()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
