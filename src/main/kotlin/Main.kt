    fun main() {
        val user1 = User(
            "Евгений",
            1
        )
        val user2 = User(
            "Василий",
            2
        )
        var message1 = Message(
            "Привет!",
            user1,
            false,
            true
        )
        var message2 = Message(
            "Как дела?",
            user2,
            false,
            true
        )
        var messages1 = mutableListOf<Message>(message1, message2)
        var chat1 = Chat(
            1,
            user1,
            user2,
            messages1
        )
        var message3 = Message(
            "Во сколько сегодня встречаемся?",
            user1,
            false,
            false
        )
        val user3 = User(
            "Татьяна",
            3
        )
        var message4 = Message(
            "В 11",
            user3,
            false,
            false
        )
        var messages2 = mutableListOf<Message>(message3, message4)
        var chat2 = Chat(
            2,
            user1,
            user3,
            messages2
        )
        val user4 = User(
            "Дмитрий",
            4
        )
        var message5 = Message(
            "Здравствуйте",
            user4,
            false,
            true
        )
        var message6 = Message(
            "Привет",
            user3,
            false,
            false
        )
        var messages3 = mutableListOf<Message>(message5, message6)
        var chat3 = Chat(
            3,
            user3,
            user4,
            messages3
        )
        var userList = mutableListOf<User>(user1, user2, user3, user4)
        var chatList = mutableListOf<Chat>(chat1, chat2, chat3)
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
        println("Количество непрочитанных чатов у пользователя ${user1.name}: ${chat1.getUnreadChatsCount(1)}")
    }
