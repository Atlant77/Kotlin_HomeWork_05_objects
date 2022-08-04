package attachment

import java.sql.Array

//1. Фотография (type = photo)
//3. Видеозапись (type = video)
//4. Аудиозапись (type = audio)
//5. Документ (type = doc)
//8. Заметка (type = note)
//18. Встреча (type = event)

interface Attachment {
    val type: String
}

class Photo(
    val id: Int, // id integer Идентификатор фотографии.
    val albumId: Int, // album_id integer Идентификатор альбома, в котором находится фотография.
    val ownerId: Int, // owner_id integer Идентификатор владельца фотографии.
    val userId: Int, // User_id integer Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе). Для фотографий, размещенных от имени сообщества, user_id = 100.
    val text: String, // text string Текст описания фотографии.
    val date: Int, // date integer Дата добавления в формате Unixtime.
    val sizesOfPhoto: SizesOfPhoto, // sizes array Массив с копиями изображения в разных размерах. Каждый объект массива содержит следующие поля:
    // type (string) — тип копии. См. Формат описания размеров фотографии.
    // url (string) — URL копии.
    // width (integer) — высота в px.
    // height (integer) — ширина в px.
    val width: Int, // width* integer Ширина оригинала фотографии в пикселах.
    val height: Int // height* integer Высота оригинала фотографии в пикселах.
)

class SizesOfPhoto(
    val type: String, // type (string) — тип копии. См. Формат описания размеров фотографии.
    val url: String, // url (string) — URL копии.
    val width: Int, // width (integer) — высота в px.
    val height: Int // height (integer) — ширина в px.
)

data class PhotoAttachment(
    val photo: Photo
) : Attachment {
    override val type: String = "photo"
}

class Video(
    val id: Int, // id integer	Идентификатор видеозаписи.
    val ownerId: Int, // owner_id integer	Идентификатор владельца видеозаписи.
    val title: String, // title string	Название видеозаписи.
    val description: String, // description string	Текст описания видеозаписи.
    val duration: Int, // duration integer	Длительность ролика в секундах.
    val image: Image, //image array	Изображение обложки. Содержит массив объектов с полями:
//"height" (integer) — Высота изображения.
//"url" (string) — Ссылка на изображение
//"width" (integer) — Ширина изображение
//"with_padding" (integer) — Поле возвращается, если изображение с отбивкой, всегда содержит 1.
    val firstFrame: FirstFrame, //first_frame array	Изображение первого кадра. Содержит массив объектов с полями:
//"height" (integer) — Высота изображения.
//"url" (string) — Ссылка на изображение
//"width" (integer) — Ширина изображение
    val date: Int, // date integer	Дата создания видеозаписи в формате Unixtime.
    val addingDate: Int, // adding_date integer	Дата добавления видеозаписи пользователем или группой в формате Unixtime.
    val views: Int, // views integer	Количество просмотров видеозаписи.
    val localViews: Int, // local_views integer	Если видео внешнее, количество просмотров в ВК.
    val comments: Int, // comments integer	Количество комментариев к видеозаписи.
    val player: String, // Player string	URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере. Поддерживается flash и html5, плеер всегда масштабируется по размеру окна.
    val platform: String, // platform string	Название платформы (для видеозаписей, добавленных с внешних сайтов).
    val canAdd: Boolean, // can_add integer, [0,1]	Может ли пользователь добавить видеозапись к себе. 0 — Не может добавить. 1 — Может добавить.
    val isPrivate: Boolean, // is_private integer, [1]	Поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1.
    val accessKey: String, // access_key string	Ключ доступа к объекту. Подробнее см. Ключ доступа к данным access_key.
    val processing: Boolean, // processing integer, [1]	Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1.
    val isFavorite: Boolean, // is_favorite boolean	true, если объект добавлен в закладки у текущего пользователя.
    val canComment: Boolean, // can_comment integer, [0,1]	Может ли пользователь комментировать видео. 0 — Не может комментировать. 1 — Может комментировать.
    val canEdit: Boolean, // can_edit integer, [0,1]	Может ли пользователь редактировать видео. 0 — Не может редактировать. 1 — Может редактировать.
    val canLike: Boolean, // can_like integer, [0,1]	'Может ли пользователь добавить видео в список <<Мне нравится>>. 0 — Не может добавить. 1 — Может добавить.
    val canRepost: Boolean, // can_repost integer, [0,1]	Может ли пользователь сделать репост видео. 0 — Не может сделать репост. 1 — Может сделать репост.
    val canSubscribe: Boolean, // can_subscribe integer, [0,1]	Может ли пользователь подписаться на автора видео. 0 — Не может подписаться. 1 — Может подписаться.
    val canAddToFaves: Boolean, // Can_add_to_faves integer, [0,1]	Может ли пользователь добавить видео в избранное. 0 — Не может добавить. 1 — Может добавить.
    val canAttachLink: Boolean, // can_attach_link integer, [0,1]	Может ли пользователь прикрепить кнопку действия к видео. 0 — Не может прикрепить. 1 — Может прикрепить.
    val width: Int, // width integer	Ширина видео.
    val height: Int, // height integer	Высота видео.
    val userId: Int, // user_id integer	Идентификатор пользователя, загрузившего видео, если оно было загружено в группу одним из участников.
    val converting: Boolean, // converting integer, [0,1]	Конвертируется ли видео. 0 — Не конвертируется. 1 — Конвертируется.
    val added: Boolean, // added integer, [0,1]	Добавлено ли видео в альбомы пользователя. 0 — Не добавлено. 1 — Добавлено.
    val isSubscribed: Boolean, // is_subscribed integer, [0,1]	Подписан ли пользователь на автора видео. 0 — Не подписан. 1 — Подписан.
    val repeat: Boolean, // repeat integer	Поле возвращается в том случае, если видео зациклено, всегда содержит 1
    val type: String, // type string	Тип видеозаписи. Может принимать значения: "video", "music_video", "movie".
    val balance: Int, // balance integer	Баланс донатов в прямой трансляции.
    val liveStatus: String, // live_status string	Статус прямой трансляции. Может принимать значения: "waiting", "started", "finished", "failed", "upcoming".
    val live: Boolean, // live integer, [1]	Поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1. Обратите внимание, в этом случае в поле duration содержится значение 0.
    val upcoming: Int, // upcoming integer, [1]	(для live = 1). Поле свидетельствует о том, что трансляция скоро начнётся.
    val spectators: Int, // spectators integer	Количество зрителей прямой трансляции.
    val likes: Likes, // likes object	Содержит объект отметки <<Мне нравится>>.
// "count" (integer) — Количество лайков.
// "user_likes" (integer, [0,1]) — Добавлено ли видео в список <<Мне нравится>> текущего пользователя. 0 — Не добавлено. 1 — Добавлено.
    val reposts: Reposts // reposts object	Содержит объект репоста.
//"count" (integer) — Счетчик общего количества репостов. Содержит сумму репостов на стену и в личные сообщения.
//"wall_count" (integer) — Счетчик репостов на стену.
//"mail_count" (integer) — Счетчик репостов в личные сообщения.
//"user_reposted" (integer) — Информация о том, сделал ли текущий пользователь репост этого видео.
)

class Image(
    val height: Int, //"height" (integer) — Высота изображения.
    val url: String, // "url" (string) — Ссылка на изображение
    val width: Int, // "width" (integer) — Ширина изображение
    val withPadding: Int // "with_padding" (integer) — Поле возвращается, если изображение с отбивкой, всегда содержит 1.
)

class FirstFrame(
    val height: Int, // "height" (integer) — Высота изображения.
    val url: String, // "url" (string) — Ссылка на изображение
    val width: Int // "width" (integer) — Ширина изображение
)

class Likes(
    val count: Int, // "count" (integer) — Количество лайков.
    val userLikes: Boolean // "user_likes" (integer, [0,1]) — Добавлено ли видео в список <<Мне нравится>> текущего пользователя. 0 — Не добавлено. 1 — Добавлено.
)

class Reposts(
    val count: Int, // "count" (integer) — Счетчик общего количества репостов. Содержит сумму репостов на стену и в личные сообщения.
    val wallCount: Int, // "wall_count" (integer) — Счетчик репостов на стену.
    val mailCount: Int, // "mail_count" (integer) — Счетчик репостов в личные сообщения.
    val userReposted: Int //"user_reposted" (integer) — Информация о том, сделал ли текущий пользователь репост этого видео.
)

class VideoAttachment(
    val video: Video
) : Attachment {
    override val type: String = "video"
}

class Audio(
    val id: Int, // id integer Идентификатор аудиозаписи.
    val ownerId: Int, // owner_id integer Идентификатор владельца аудиозаписи.
    val artist: String, // artist string Исполнитель.
    val title: String, // title string Название композиции.
    val duration: Int, // duration  integer Длительность аудиозаписи в секундах.
    val url: String, // url string Ссылка на mp3.
    val lyricsId: Int, // lyrics_id  integer Идентификатор текста аудиозаписи (если доступно).
    val albumId: Int, // album_id integer Идентификатор альбома, в котором находится аудиозапись (если присвоен).
    val genreId: Int, // genre_id integer Идентификатор жанра из списка аудио жанров.
    val date: Int, // date integer Дата добавления.
    val noSearch: Boolean, // no_search integer 1, если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается.
    val isHq: Boolean //is_hq integer 1, если аудио в высоком качестве.

//Жанры аудиозаписей
//Жанр возвращается в виде числа в поле genre при получении информации об аудиозаписи. Поле genre может содержать следующие значения:
//
//1 — Rock;
//2 — Pop;
//3 — Rap & Hip-Hop;
//4 — Easy Listening;
//5 — House & Dance;
//6 — Instrumental;
//7 — Metal;
//21 — Alternative;
//8 — Dubstep;
//1001 — Jazz & Blues;
//10 — Drum & Bass;
//11 — Trance;
//12 — Chanson;
//13 — Ethnic;
//14 — Acoustic & Vocal;
//15 — Reggae;
//16 — Classical;
//17 — Indie Pop;
//19 — Speech;
//22 — Electropop & Disco;
//18 — Other.
)
class AudioAttachment(
    val audio: Audio
) : Attachment {
    override val type: String = "audio"
}

class Document(
    val id: Int, // id integer Идентификатор файла.
    val ownerId: Int, // owner_id integer Идентификатор пользователя, загрузившего файл.
    val title: String, // title string Название файла.
    val size: Int, // size integer Размер файла в байтах.
    val ext: String, // ext string Расширение файла.
    val url: String, // url string Адрес файла, по которому его можно загрузить.
    val date: Int, // date integer Дата добавления в формате Unixtime.
    val type: Int, // type integer Тип файла.  Возможные значения:
    //1 — текстовые документы;
    //2 — архивы;
    //3 — gif;
    //4 — изображения;
    //5 — аудио;
    //6 — видео;
    //7 — электронные книги;
    //8 — неизвестно.

    val preview: Preview, //preview object Информация для предварительного просмотра файла. Может содержать следующие поля:
//photo (object) — изображения для предпросмотра. Содержит единственное поле:
//sizes (array) — массив копий изображения в разных размерах. Подробное описание структуры вы найдёте на этой странице.

    val graffiti: Graffiti, // graffiti (object) — данные о граффити. Содержит следующие поля:
//src (string) — URL файла с граффити;
//width (integer) — ширина изображения в px;
//height (integer) — высота изображения в px.

    val audioMessage: AudioMessage // audio_message — данные об аудиосообщении. Объект, который содержит следующие поля:
//duration (integer) — длительность аудиосообщения в секундах;
//waveform (array) — массив значений (integer) для визуального отображения звука;
//link_ogg (string) — URL .ogg-файла;
//link_mp3 (string) — URL .mp3-файла.
)
class Preview (
    val photoPreview: Array // photo (object) — изображения для предпросмотра. Содержит единственное поле:
//sizes (array) — массив копий изображения в разных размерах. Подробное описание структуры вы найдёте на этой странице.
)

class Graffiti (
    val src: String, // src (string) — URL файла с граффити;
    val width: Int, // width (integer) — ширина изображения в px;
    val height: Int, // height (integer) — высота изображения в px.
)

class AudioMessage (
    val duration: Int, // duration (integer) — длительность аудиосообщения в секундах;
    val waveform: Array, // waveform (array) — массив значений (integer) для визуального отображения звука;
    val linkOgg: String, // link_ogg (string) — URL .ogg-файла;
    val linkMp3: String// link_mp3 (string) — URL .mp3-файла.
)

class DocAttachment(
    val doc: Document
) : Attachment {
    override val type: String = "document"
}

class Note(
    val id: Int, // id integer	Идентификатор заметки.
    val ownerId: Int, // owner_id integer	Идентификатор владельца заметки.
    val title: String, // title string	Заголовок заметки.
    val text: String, // text string	Текст заметки.
    val date: Int, // date integer	Дата создания заметки в формате Unixtime.
    val comments: Int, // comments integer	Количество комментариев.
    val readComments: Int, // read_comments integer	Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).

    val viewUrl: String, // view_url string	URL страницы для отображения заметки.
    val privacyView: String, //privacy_view string[]	Настройки приватности просмотра заметки
    val privacyComment: String, //privacy_comment string[]	Настройки приватности комментирования заметки
    val canComment: Boolean, //can_comment integer	Есть ли возможность оставлять комментарии
    val textWiki: String //text_wiki string	Тэги ссылок на wiki
)
class NoteAttachment(
    val note: Note
) : Attachment {
    override val type: String = "note"
}

class Event(
    val id: Int, //id integer	Идентификатор встречи.
    val time: Int, //time integer	Время начала встречи в Unixtime
    val memberStatusEvent: Int, //member_status integer	Идёт ли текущий пользователь на встречу. Возможные значения:
        //1 -- точно идёт;
        //2 -- возможно пойдёт;
        //3 -- не идёт.
    val isFavorite: Boolean, //is_favorite bool	Добавлена ли встреча в закладки.
    val address: String, //address (string)	Место проведения встречи.
    val text: String, //text (string)	Текст для отображения сниппета.
    val buttonText: String, //button_text (string)	Текст на кнопке сниппета.
    val friends: ArrayList<Int> //friends (integer[])	Список идентификаторов друзей, которые также идут на мероприятие.
)

class EventAttachment(
    val event: Event
) : Attachment {
    override val type: String = "event"
}