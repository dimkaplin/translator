package dkaplin.translator.view.base

import dkaplin.translator.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}
