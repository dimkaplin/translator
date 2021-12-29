package geekbrains.ru.translator

import dkaplin.translator.model.data.Meaning
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeUnitTestOne {

    @Test
    fun simpleTest_ReturnsTrue() {
        Assert.assertTrue( 6>7)
    }

    @Test
    fun simpleTest_ReturnsFalse() {
        Assert.assertFalse( 7-3<1)
    }

    @Test
    fun TITLE_EXTRA_toBooleanStrict_False() {
         val TITLE_EXTRA = "89cbce59-e28f-418f-b470-ff67125c2e2f"
        Assert.assertFalse(TITLE_EXTRA.toBooleanStrict() )
    }

    @Test
    fun meanings_Empty_ReturnsFalse() {
        val meanings: List<Meaning> = listOf()
        Assert.assertFalse(meanings.isEmpty())
    }


}