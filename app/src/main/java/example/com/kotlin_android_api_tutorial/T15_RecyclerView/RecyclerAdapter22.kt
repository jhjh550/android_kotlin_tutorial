package example.com.kotlin_android_api_tutorial.T15_RecyclerView


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.card_layout.view.*

class RecyclerAdapter22(val data:Array<MyData>) : RecyclerView.Adapter<RecyclerAdapter22.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int) = ViewHolder(parent)

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        with(viewHolder){
            itemTitle.text = data[i].title
            itemDetail.text = data[i].desc
            itemImage.setImageResource(data[i].img)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
    ){
        val itemImage = itemView.item_image
        val itemTitle = itemView.item_title
        val itemDetail = itemView.item_detail

    }



}






/*
*
* private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item file details", "Item six details",
        "Item seven details", "Item eight details")

    private val images = intArrayOf(
        R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)*/