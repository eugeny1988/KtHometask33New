data class Message(
    var text: String,
    val user: User,
    var isDeleted: Boolean,
    var isRead: Boolean,
) {
}