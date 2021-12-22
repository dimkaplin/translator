package dkaplin.translator.di

import androidx.room.Room
import dkaplin.model.data.dto.SearchResultDto
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.datasource.RetrofitImplementation
import dkaplin.translator.model.datasource.RoomDataBaseImplementation
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryImplementation
import dkaplin.translator.model.repository.RepositoryImplementationLocal
import dkaplin.translator.model.repository.RepositoryLocal
import dkaplin.translator.room.HistoryDataBase
import dkaplin.translator.view.history.HistoryActivity
import dkaplin.translator.view.history.HistoryInteractor
import dkaplin.translator.view.history.HistoryViewModel
import dkaplin.translator.view.main.MainActivity
import dkaplin.translator.view.main.MainInteractor
import dkaplin.translator.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
