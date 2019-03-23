package example.com.kotlin_android_api_tutorial.T26_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import example.com.testretrofit.ApiInterface
import example.com.testretrofit.Post
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)



        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retrofit.create(ApiInterface::class.java).getPosts()
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code())
                    return
                }

                val posts = response.body()

                if(posts != null) {
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

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                textViewResult.setText(t.message)
            }
        })
    }
}
