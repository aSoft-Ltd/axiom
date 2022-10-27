import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.fail

class Random {
    @Test
    fun should_pass() {
        assertEquals(2, 1 + 1)
    }

    @Test
    fun should_fail() {
        assertFails {
            fail()
        }
    }
}