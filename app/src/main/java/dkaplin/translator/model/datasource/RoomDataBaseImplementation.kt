package dkaplin.translator.model.datasource

import dkaplin.translator.model.data.WordModel
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<WordModel>> {

    override fun getData(word: String): List<WordModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
