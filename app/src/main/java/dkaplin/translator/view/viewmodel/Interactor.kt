package dkaplin.translator.view.viewmodel

interface Interactor<T> {

    suspend  fun getData(word: String, fromRemoteSource: Boolean): T
}
