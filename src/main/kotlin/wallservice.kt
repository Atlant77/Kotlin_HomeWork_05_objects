import attachment.Attachment

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

//    fun likeById(id: Int){
//        for ((index, post)in posts.withIndex()){
//            if (post.id == id) {
//                posts[index] = post.copy(likes = post.likes + 1)
//            }
//
//        }
//    }

}