package dkaplin.translator.model.datasource

import dkaplin.model.data.dto.SearchResultDto
import dkaplin.translator.model.data.WordModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<SearchResultDto>>
}
