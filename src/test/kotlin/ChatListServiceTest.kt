import org.junit.Test

import org.junit.Assert.*

class ChatListServiceTest {

    @Test
    fun ChatListService.messagesList() {
        val expectedValue = mutableListOf(message1, message2)
        val realValue = messagesList(1, 1, 1)
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun ChatListService.getUnreadChatsCount() {
        val expectedValue = 2
        val realValue = chat1.getUnreadChatsCount(1)
        assertEquals(expectedValue, realValue)
    }
}