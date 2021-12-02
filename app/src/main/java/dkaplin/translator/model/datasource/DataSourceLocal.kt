package dkaplin.translator.model.datasource

import dkaplin.translator.model.data.WordModel
import io.reactivex.Observable

class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<WordModel>> {

    override fun getData(word: String): List<WordModel> = remoteProvider.getData(word)
}
