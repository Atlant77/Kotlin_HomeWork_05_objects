import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    //на add - всего один, который проверяет, что после добавления поста id стал не равным 0.
    fun add() {
        // arrange
        val post = Post(
            3, 5, 5, 6, 1618536906, "Post ID = 3 updated...", 6, 145, false,
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
            1
        )

        // act
        val checkId = post.id

        // assert
        assertNotNull(checkId)
    }

    @Test
    //изменяем пост с существующим id, возвращается true;
    fun updateTrue() {
        // arrange
        val service = WallService

        service.add(Post(
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
            1
        ))
        service.add( Post(
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
            1
        ))
        service.add(Post(
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
            1
        ))


        val update = Post(
            3, 5, 5, 6, 1618536906, "Post ID = 3 updated...", 6, 145, false,
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
            1
        )
        // act
        val result = service.update(update)

        // assert
        assertTrue(result)
    }

    @Test
    //изменяем пост с несуществующим id, возвращается false.
    fun updateFalse() {
        // arrange
        val service = WallService

        service.add(Post(
            4, 4, 4, 2, 1618836906, "Post ID = 6...", 3, 45, true,
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
            1
        ))
        service.add( Post(
            2, 4, 4, 2, 1613836906, "Post ID = 3...", 3, 45, true,
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
            1
        ))
        service.add(Post(
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
            1
        ))


        val update = Post(
            6, 5, 5, 6, 1618536906, "Post ID = 3 updated...", 6, 145, false,
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
            1
        )
        // act
        val result = service.update(update)

        // assert
        assertFalse(result)
    }
}