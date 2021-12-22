package dkaplin.translator.model.datasource

import dkaplin.model.data.dto.SearchResultDto
import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.room.HistoryDao
import dkaplin.translator.utils.convertDataModelSuccessToEntity
import dkaplin.translator.utils.mapHistoryEntityToSearchResult

//import dkaplin.translator.utils.mapHistoryEntityToSearchResult


class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
