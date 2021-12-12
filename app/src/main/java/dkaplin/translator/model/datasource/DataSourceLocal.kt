package dkaplin.translator.model.datasource

import dkaplin.translator.model.data.AppState


interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
