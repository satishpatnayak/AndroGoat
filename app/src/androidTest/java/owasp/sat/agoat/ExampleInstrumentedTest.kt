package owasp.sat.agoat

<<<<<<< HEAD
import org.junit.Test
=======
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

import org.junit.Assert.*

/**
<<<<<<< HEAD
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
=======
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
        assertEquals("owasp.sat.agoat", appContext.packageName)
    }
}
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
