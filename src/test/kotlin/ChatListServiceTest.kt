import ChatListService.getUnreadChatsCount
import org.junit.Test

import org.junit.Assert.*

class ChatListServiceTest {

    @Test
    fun messagesList() {
        val expectedValue = mutableListOf<Message>()
        val realValue = ChatListService.messagesList(1, 1, 2)
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun getUnreadChatsCount() {
        val expectedValue = 1
        val realValue = chat1.getUnreadChatsCount(1)
        assertEquals(expectedValue, realValue)
    }
}