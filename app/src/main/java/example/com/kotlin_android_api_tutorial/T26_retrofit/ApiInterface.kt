package example.com.testretrofit

import example.com.kotlin_android_api_tutorial.T26_retrofit.MyComment
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    fun getPosts() : Call<List<MyPost>>

//    @GET("posts/1/comments")
//    fun getComments() : Call<List<MyComment>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int) : Call<List<MyComment>>

    @GET("posts")
    fun getPosts(@Query("userId") userId: Int) : Call<List<MyPost>>

    @GET("posts")
    fun getPosts(@QueryMap parameters:Map<String, String>)

    @POST("posts")
    fun createPost(@Body myPost: MyPost) : Call<MyPost>
}