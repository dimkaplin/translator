package dkaplin.translator.view.main

import androidx.lifecycle.LiveData
import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.datasource.DataSourceLocal
import dkaplin.translator.model.datasource.DataSourceRemote
import dkaplin.translator.model.repository.RepositoryImplementation
import dkaplin.translator.utils.parseSearchResults
import dkaplin.translator.view.viewmodel.BaseViewModel
//import dkaplin.translator.viewmodel.BaseViewModel
import io.reactivex.observers.DisposableObserver
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>() {*/

//class MainViewModel @Inject constructor(private val interactor: MainInteractor) :
class MainViewModel(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    private var appState: AppState? = null

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    //override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
    override fun getData(word: String, isOnline: Boolean) {
    /*compositeDisposable.add(
        interactor.getData(word, isOnline)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }
            .subscribeWith(getObserver())
    )
    return super.getData(word, isOnline)*/
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) = withContext(Dispatchers.IO) {
        _mutableLiveData.postValue(parseSearchResults(interactor.getData(word, isOnline)))
    }

    /*private fun getObserver(): DisposableObserver<AppState> {
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
    }*/
}
