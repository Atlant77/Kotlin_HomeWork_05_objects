import attachment.Attachment

data class Post(
    var id: Int, //Идентификатор записи.
    val ownerId: Int, //Идентификатор владельца стены, на которой размещена запись.
    val fromId: Int?, //Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int, //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    val date: Int, //Время публикации записи в формате unixtime.
    val text: String, //Текст записи.
    val replyOwnerId: Int?, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly: Boolean, //1, если запись была создана с опцией «Только для друзей».
    var comments: Array<Comment>?, //Информация о комментариях к записи
    val copyright: Copyright, //Источник материала, объект с полями:
    val likes: Likes, //Информация о лайках к записи, объект с полями:
    val reposts: Reposts, //Информация о репостах записи («Рассказать друзьям»), объект с полями:
    val views: Views, //Информация о просмотрах записи. Объект с единственным полем:
    val postType: String, //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val canPin: Boolean, //Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete: Boolean, //Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit: Boolean, //Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
    val isPinned: Boolean, //Информация о том, что запись закреплена.
    val markedAsAds: Boolean, //Информация о том, содержит ли запись отметку «реклама» (1 — да, 0 — нет).
    val isFavorite: Boolean, //true, если объект добавлен в закладки у текущего пользователя.
    val donut: Donut, //Информация о записи VK Donut:
    val postponedId: Int?, //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    var attachments: Attachment? //Приложения
)

class ThreadComments(
    val count: Int, //count (integer) — количество комментариев в ветке.
    val items: Array<String>, //items (array) — массив объектов комментариев к записи (только для метода wall.getComments).
    val canPost: Boolean, //can_post (boolean) – может ли текущий пользователь оставлять комментарии в этой ветке.
    val showReplyButton: Boolean, //show_reply_button (boolean) – нужно ли отображать кнопку «ответить» в ветке.
    val groupsCanPost: Boolean //groups_can_post (boolean) – могут ли сообщества оставлять комментарии в ветке.
)

//comments
//object
//Информация о комментариях к записи, объект с полями:
data class Comment(
    val id: Int, //id integer Идентификатор комментария.
    val fromId: Int, //from_id integer Идентификатор автора комментария.
    val date: Int, //date integer Дата создания комментария в формате Unixtime.
    val text: String, //text string Текст комментария.
    val donut: Donut, //donut object Информация о VK Donut. Объект со следующими полями:
//is_don (boolean) — является ли комментатор подписчиком VK Donut.
//placeholder (string) — заглушка для пользователей, которые не оформили подписку VK Donut.
    val replyToUser: Int, //reply_to_user integer Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val replyToComment: Int, //reply_to_comment integer Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments: Attachment?, //Attachments object Медиавложения комментария (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
    val parents_stack: Array<Int>, //parents_stack array Массив идентификаторов родительских комментариев.
    val threadComments: ThreadComments, //thread object Информация о вложенной ветке комментариев, объект с полями:
//count (integer) — количество комментариев в ветке.
//items (array) — массив объектов комментариев к записи (только для метода wall.getComments).
//can_post (boolean) – может ли текущий пользователь оставлять комментарии в этой ветке.
//show_reply_button (boolean) – нужно ли отображать кнопку «ответить» в ветке.
//groups_can_post (boolean) – могут ли сообщества оставлять комментарии в ветке.
)


//copyright
//object
//Источник материала, объект с полями:
data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

//likes
//object
//Информация о лайках к записи, объект с полями:
data class Likes(
    val count: Int, //число пользователей, которым понравилась запись;
    val userLikes: Boolean, //наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    val canLike: Boolean, //информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    val canPublish: Boolean //информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
)

data class Reposts(
    val count: Int, //число пользователей, скопировавших запись;
    val userReposted: Boolean //наличие репоста от текущего пользователя (1 — есть, 0 — нет).
)

//views
//object
//Информация о просмотрах записи. Объект с единственным полем:
data class Views(
    val count: Int //число просмотров записи.
)

data class Donut(
    val isDonut: Boolean, //запись доступна только платным подписчикам VK Donut;
    val paidDuration: Int, //время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder: String, //Заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
    val canPublishFreeCopy: Boolean, //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val editMode: String //Информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
// - all — всю информацию о VK Donut.
// - duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.
)