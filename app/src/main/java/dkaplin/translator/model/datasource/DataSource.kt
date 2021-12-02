package dkaplin.translator.model.datasource

import io.reactivex.Observable

interface DataSource<T> {

    fun getData(word: String): T
}
