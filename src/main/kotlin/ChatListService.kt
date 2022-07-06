object ChatListService {

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

fun Chat.getUnreadChatsCount(id: Int): Int {
    var tempUserList = mutableListOf<User>()
    var count = 0
    userList.map { user: User ->
        if (user.id == id) {
            chatList.map {
                if ((it.user1 === user || it.user2 === user) && !it.isChatRead) {
                    count++
                }
            }
        }
    }

    return count
}