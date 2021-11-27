package dkaplin.translator.model.datasource

import dkaplin.translator.model.data.WordModel
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<WordModel>> {

    override fun getData(word: String): Observable<List<WordModel>> = remoteProvider.getData(word)
}
