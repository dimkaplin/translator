package dkaplin.translator.di

import androidx.room.Room
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.datasource.RetrofitImplementation
import dkaplin.translator.model.datasource.RoomDataBaseImplementation
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryImplementation
import dkaplin.translator.model.repository.RepositoryImplementationLocal
import dkaplin.translator.model.repository.RepositoryLocal
import dkaplin.translator.room.HistoryDataBase
import dkaplin.translator.view.history.HistoryInteractor
import dkaplin.translator.view.history.HistoryViewModel
import dkaplin.translator.view.main.MainInteractor
import dkaplin.translator.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<WordModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<WordModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
