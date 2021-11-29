package dkaplin.translator.view.main

import androidx.lifecycle.LiveData
import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.datasource.DataSourceLocal
import dkaplin.translator.model.datasource.DataSourceRemote
import dkaplin.translator.model.repository.RepositoryImplementation
import dkaplin.translator.view.viewmodel.BaseViewModel
//import dkaplin.translator.viewmodel.BaseViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/*class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>() {*/

class MainViewModel @Inject constructor(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {

    private var appState: AppState? = null

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}
