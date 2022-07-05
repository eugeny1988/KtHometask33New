object ChatListService {

    fun Chat.getUnreadChatsCount(id: Int): Int {
        var count = 0
        for (user: User in userList) {
            if (user.id == id) {
                for (chat: Chat in chatList) {
                    if ((chat.user1 === user || chat.user2 === user) && !chat.isChatRead) {
                        count++
                    }
                }
            }
        }
        return count
    }
    fun messagesList(chatId: Int, messageId: Int, count: Int): MutableList<Message> {
        var chatFound = mutableListOf<Chat>()
        val chatFoundFunction = chatList.forEach { chat: Chat -> if (chat.id == chatId) chatFound.add(chat) }
        val messagesReturn = { message: Message -> !message.isRead }
        var unreadMessagesList = mutableListOf<Message>()
        var i = 1
        var unreadMessages = chatFound.map {
            if (!it.messages[i - 1].isRead && i <= count && i >= messageId) unreadMessagesList.add(it.messages[i - 1])
            i++
            it.messages[i - 1].isRead = true
        }
        return unreadMessagesList
    }
}