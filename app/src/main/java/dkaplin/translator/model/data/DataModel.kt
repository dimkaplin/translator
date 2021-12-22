package dkaplin.translator.model.data

import com.google.gson.annotations.SerializedName

data class WordModel(
    /*@field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?*/

    val text: String = "",
    val meanings: List<Meaning> = listOf()
)
