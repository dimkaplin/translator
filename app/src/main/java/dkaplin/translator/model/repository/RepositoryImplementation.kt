package dkaplin.translator.model.repository

import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<WordModel>>) :
    Repository<List<WordModel>> {

    override suspend fun getData(word: String): List<WordModel> {
        return dataSource.getData(word)
    }
}
