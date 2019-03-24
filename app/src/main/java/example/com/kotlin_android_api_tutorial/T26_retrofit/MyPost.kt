package example.com.testretrofit

import com.google.gson.annotations.SerializedName

data class MyPost(
    val userId: Int,
    val id: Int,
    val title: String,
    @SerializedName("body") val text: String){

    constructor(userId:Int, title:String, text:String):this(userId, 0, title, text)
}