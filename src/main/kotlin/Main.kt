import java.util.Objects

data class Post(
    var id: Long = 0,
    val text: String = "",
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val replyOwnerId: Long? = null,
    val replyPostId: Long? = null,
    val friendsOnly: Boolean = true

)

data class Views(val count: Int = 0)


object WallService {

    private var posts = emptyArray<Post>()
    private var lastId = 0L

    fun clear() {
        posts = emptyArray()
        lastId = 0L
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }


    fun printPost() {
        for (post in posts) {
            print(post)
            print(' ')
        }
        println()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }
    fun printPosts() {
        for (post in posts) {
            print(post)
            println(' ')
        }
    }
    fun removeById(id: Long) {

    }

}

fun main() {
    WallService.add(Post())
    WallService.printPost()
    WallService.add(Post(text = "Boom"))
    WallService.add(Post(text = "Doom"))
    WallService.printPost()
    WallService.update(Post(2, text = "New Text"))
    WallService.printPost()
    println(WallService.update(Post(2, text = "New Text")))
    println(WallService.update(Post(20, text = "New Text")))


}