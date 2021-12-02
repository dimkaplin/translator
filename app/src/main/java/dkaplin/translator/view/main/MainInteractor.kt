package dkaplin.translator.view.main

//import dkaplin.translator.viewmodel.Interactor
import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.view.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<WordModel>>,
    private val repositoryLocal: Repository<List<WordModel>>
) : Interactor<AppState> {

    /*override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }*/
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
