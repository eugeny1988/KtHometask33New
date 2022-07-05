import org.junit.Test

import org.junit.Assert.*

class MainKtTest {


    @Test
    fun createChat() {
        val expectedValue = Chat(
            6,
            user1,
            user3,
            mutableListOf(message1)
        )
        val realValue = createChat(user1, user3, message1)
        assertEquals(expectedValue, realValue)
    }
}

