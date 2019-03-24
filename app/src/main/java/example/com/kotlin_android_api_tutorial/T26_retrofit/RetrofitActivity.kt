package example.com.kotlin_android_api_tutorial.T26_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import example.com.testretrofit.ApiInterface
import example.com.testretrofit.MyPost
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
//        getPosts()
//        getComments()
//        getPosts(1)
        createPost()
    }


    fun createPost(){
        val post = MyPost(23, 0,"New Title", "New Text")
        val call = apiInterface.createPost(post)

        call.enqueue(object: Callback<MyPost>{
            override fun onFailure(call: Call<MyPost>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MyPost>, response: Response<MyPost>) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code())
                    return
                }

                val postResponse = response.body()
                var content = ""
                if(postResponse != null) {
                    content += "Code: " + response.code() + "\n"
                    content += "ID: " + postResponse.id + "\n"
                    content += "User ID: " + postResponse.userId + "\n"
                    content += "Title: " + postResponse.title + "\n"
                    content += "Text: " + postResponse.text + "\n\n"
                }

                textViewResult.text = content
            }

        })
    }

    fun getPosts(userId: Int){
        val call = apiInterface.getPosts(userId)
        call.enqueue(object : Callback<List<MyPost>>{
            override fun onFailure(call: Call<List<MyPost>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<MyPost>>, response: Response<List<MyPost>>) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code())
                    return
                }

                val posts = response.body()

                if (posts != null) {
                    for (post in posts) {
                        var content = ""
                        content += "ID: " + post.id + "\n"
                        content += "User ID: " + post.userId + "\n"
                        content += "Title: " + post.title + "\n"
                        content += "Text: " + post.text + "\n\n"

                        textViewResult.append(content)
                    }
                }
            }

        })
    }

    fun getPosts() {
        val call = apiInterface.getPosts()

        call.enqueue(object : Callback<List<MyPost>> {

            override fun onResponse(call: Call<List<MyPost>>, response: Response<List<MyPost>>) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code())
                    return
                }

                val posts = response.body()

                if (posts != null) {
                    for (post in posts) {
                        var content = ""
                        content += "ID: " + post.id + "\n"
                        content += "User ID: " + post.userId + "\n"
                        content += "Title: " + post.title + "\n"
                        content += "Text: " + post.text + "\n\n"

                        textViewResult.append(content)
                    }
                }
            }

            override fun onFailure(call: Call<List<MyPost>>, t: Throwable) {
                textViewResult.setText(t.message)
            }
        })
    }

    private fun getComments(){
        var call = apiInterface.getComments(1)

        call.enqueue(object : Callback<List<MyComment>>{
            override fun onFailure(call: Call<List<MyComment>>, t: Throwable) {
                textViewResult.append(t.message)
            }

            override fun onResponse(call: Call<List<MyComment>>, response: Response<List<MyComment>>) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code())
                    return
                }

                val comments = response.body()
                if(comments != null){
                    for(comment in comments){
                        var content = ""
                        content += "ID: " + comment.id + "\n"
                        content += "MyPost ID: " + comment.postId + "\n"
                        content += "Name: " + comment.name + "\n"
                        content += "Email: " + comment.email + "\n"
                        content += "Text: " + comment.text + "\n\n"

                        textViewResult.append(content)
                    }
                }
            }

        })
    }


}
