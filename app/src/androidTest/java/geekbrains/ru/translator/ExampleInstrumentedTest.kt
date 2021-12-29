package geekbrains.ru.translator

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import dkaplin.model.data.dto.SearchResultDto
import dkaplin.translator.model.data.AppState
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.utils.mapSearchResultToResult
import dkaplin.translator.view.history.HistoryAdapter
import kotlinx.coroutines.newFixedThreadPoolContext

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("dkaplin.translator", appContext.packageName)
        val appState: AppState
        val repositoryRemote: Repository<List<SearchResultDto>>
        var rr :  List<WordModel>
        rr = listOf()
        appState = AppState.Success(rr)
        assertEquals(appState, appContext)
    }
}
