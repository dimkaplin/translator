package dkaplin.translator.model.repository

import dkaplin.model.data.dto.SearchResultDto
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}
