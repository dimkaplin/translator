package dkaplin.translator.view.history

import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryLocal
import dkaplin.translator.view.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<WordModel>>,
    private val repositoryLocal: RepositoryLocal<List<WordModel>>
) : Interactor<AppState> {

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
