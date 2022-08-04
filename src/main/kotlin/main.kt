import attachment.*

fun main() {

    autoFillPosts()
    println()
    autoUpdatePosts()
    println()
    println(WallService.posts[0])
    println(WallService.posts[1])
    println(WallService.posts[2])

//    val attachments = PhotoAttachment(
//        Photo(
//            12, 13, 25, 44, "Просто фото", 1612836906,
//            SizesOfPhoto("Plate", "www.www.ry/link", 156, 456), 480, 590
//        )
//    )
//    val attachments2 = VideoAttachment(
//        Video(12, 13, "Video title", "Just Video", 45,
//            Image(12, "www.www.ru", 213, 213),
//            FirstFrame(235, "www.link.ru", 235), 1612836906,
//            1613836906, 12, 23, 154, "Player", "IVI", false, false,
//            "MyKey", false, false, false, false, false,false,
//            false, false, false, 1235, 896, 45, false, false,
//            false, false, "Video", 45, "LiveStatus", true, 456, 456,
//            Likes(222, true),
//            Reposts(123, 456, 45,45)
//        )
//    )
}

fun autoUpdatePosts() {
    if (WallService.update(
            Post(
                2, 5, 5, 6, 1618536906, "Post ID = 3 updated...", 6, 145, false,
                Comments(44, false, false, false, false),
                Copyright(3, "www.trueCo1.com", "TrueCo1", "CO1"),
                Likes(45, false, false, false),
                Reposts(45, true),
                Views(55),
                "post",
                true,
                false,
                false,
                false,
                false,
                false,
                Donut(false, 3, "Holder", false, "all"),
                null,
                VideoAttachment(
                    Video(
                        12, 13, "Video title", "Just Video", 45,
                        Image(12, "www.www.ru", 213, 213),
                        FirstFrame(235, "www.link.ru", 235), 1612836906,
                        1613836906, 12, 23, 154, "Player", "IVI", false, false,
                        "MyKey", false, false, false, false, false, false,
                        false, false, false, 1235, 896, 45, false, false,
                        false, false, "Video", 45, "LiveStatus", true, 456, 456,
                        Likes(222, true),
                        Reposts(123, 456, 45, 45)
                    )
                )
            )
        )
    ) {
        println("Информация поста изменена!")
    } else println("Пост для изменения не найден!")
}

fun autoFillPosts() {
    WallService.add(
        Post(
            1, 4, 4, 2, 1618836906, "Post ID = 6...", 3, 45, true,
            Comments(44, false, false, false, false),
            Copyright(3, "www.trueCo.com", "TrueCo", "CO"),
            Likes(45, false, false, false),
            Reposts(45, true),
            Views(55),
            "post",
            true,
            false,
            false,
            false,
            false,
            false,
            Donut(false, 3, "Holder", false, "all"),
            1,
            null
        )
    )

    WallService.add(
        Post(
            1, 4, 4, 2, 1613836906, "Post ID = 3...", 3, 45, true,
            Comments(44, false, false, false, false),
            Copyright(3, "www.trueCo2.com", "TrueCo2", "CO2"),
            Likes(45, false, false, false),
            Reposts(45, true),
            Views(55),
            "post",
            true,
            false,
            false,
            false,
            false,
            false,
            Donut(false, 3, "Holder", false, "all"),
            null,
            null
        )
    )
    WallService.add(
        Post(
            1, 4, 4, 2, 1615836906, "Post ID = 2...", 3, 45, true,
            Comments(44, false, false, false, false),
            Copyright(3, "www.trueCo3.com", "TrueCo3", "CO3"),
            Likes(45, false, false, false),
            Reposts(45, true),
            Views(55),
            "post",
            true,
            false,
            false,
            false,
            false,
            false,
            Donut(false, 3, "Holder", false, "all"),
            1,
            null
        )
    )

    println("Посты c уникальными ID добавлены автоматически")
}
