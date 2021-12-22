package dkaplin.translator.view.history

import dkaplin.model.data.dto.SearchResultDto
import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryLocal
import dkaplin.translator.utils.mapSearchResultToResult
import dkaplin.translator.view.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
