import org.junit.Test

import org.junit.Assert.*

class ChatTest {

    @Test
    fun createMessage() {
        val expectedValue = mutableListOf(message1, message2, message3)
        chat1.createMessage(message3)
        val realValue = chat1.messages
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun editMessage() {
        val expectedValue = Message(
            "Здравствуйте",
            user1,
            false,
            true
        )
        chat1.editMessage(1, "Здравствуйте", user1)
        val realValue = chat1.messages[0]
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun deleteMessage() {
        message1.isDeleted = true
        val expectedValue = mutableListOf(message2)
        chat1.deleteMessage(1)
        val realValue = mutableListOf(chat1.messages.removeAt(0))
        assertEquals(expectedValue, realValue)
    }
}