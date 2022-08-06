object WallService {
    var posts = emptyArray<Post>()
    private var uniqueId: Int = 1

    fun add(post: Post): Post {
        if (post.id != uniqueId) {
            post.id = uniqueId
        }
        posts += post
        uniqueId += 1
        return post
    }

    fun update(postUpdate: Post): Boolean {
        for (i in posts.indices) {
            if (postUpdate.id == posts[i].id) {
                println("Пост для изменения найден!")
                posts[i] = postUpdate
                return true
            }
        }
        println("Пост для изменения не найден!")
        return false
    }

    @Throws(PostNotFoundException::class)
    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
//            println("Пост Id для перебора: ${post.id}")
            if (postId == post.id) {
                println("Пост для комментария найден!")
                if (post.comments == null) {
                    post.comments = emptyArray()
                    post.comments = post.comments?.plus(comment)
                } else post.comments = post.comments?.plus(comment)
                return comment
            }
        }
        throw PostNotFoundException("Post with ID $postId not found!")
    }

    class PostNotFoundException (massage: String): RuntimeException(massage)
}