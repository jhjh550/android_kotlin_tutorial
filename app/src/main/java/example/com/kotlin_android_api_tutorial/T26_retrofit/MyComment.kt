package example.com.kotlin_android_api_tutorial.T26_retrofit

import com.google.gson.annotations.SerializedName

data class MyComment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    @SerializedName("body") val text: String
)