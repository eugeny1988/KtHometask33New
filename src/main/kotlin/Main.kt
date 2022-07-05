import ChatListService.getUnreadChatsCount
import ChatListService.messagesList

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
fun main() {
    chat2.editMessage(1,"Да", user1)


    println("Количество непрочитанных чатов у пользователя ${user1.name}: ${chat1.getUnreadChatsCount(1)}")
    val chatFilter = { chat: Chat -> chat.hasLastMessage }
    val chats = chatList.filter(chatFilter)
    println(chats)

    println(messagesList(3, 0, 2))
    val newMessage = Message(
        "Новое сообщение",
        user1,
        false,
        false
    )
    chat1.createMessage(newMessage)
    chat2.deleteMessage(1)


    val messageToNewChat = Message(
        "Привет",
        user1,
        false,
        false
    )
    var newChat = createChat(user1, user3, messageToNewChat)
    TODO("https://github.com/netology-code/kt-homeworks/tree/master/10_sequences")

}

fun createChat(userOne: User, userTwo: User, message: Message): Chat? {
    var chatExample: Chat? = null
    var isChatExist = false
    for (chat: Chat in chatList) {
        if (chat.user1 === userOne || chat.user2 === userTwo) {
            isChatExist = true
        }
    }
    if (!isChatExist) {
        chatExample = Chat(
            chatList.size + 1,
            userOne,
            userTwo,
            mutableListOf(message)
        )
    }
    return chatExample

}



