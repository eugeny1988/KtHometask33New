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

    @Test
    fun messagesList() {
        val expectedValue = mutableListOf(message1, message2)
        val realValue = messagesList(1, 1, 1)
        assertEquals(expectedValue, realValue)
    }
}