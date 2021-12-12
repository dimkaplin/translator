package dkaplin.translator.view.main


import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryLocal
import dkaplin.translator.view.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<WordModel>>,
    private val repositoryLocal: RepositoryLocal<List<WordModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
