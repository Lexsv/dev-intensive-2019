package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image: String?
):BaseMessage ("$lastId", from, chat, isIncoming, date) {
    override fun formatMessage(): String  = "id:$id ${from?.firstName} ${if (isIncoming) "получил изображение "
                                                                            else "отправил сообщение "}" +
                                            "изображение \"$image\" ${date.humanizeDiff()}"
}