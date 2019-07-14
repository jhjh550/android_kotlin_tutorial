package example.com.kotlin_android_api_tutorial.T15_RecyclerView

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import example.com.kotlin_android_api_tutorial.R

class RecyclerAdapter11(val data:Array<MyData>) : RecyclerView.Adapter<RecyclerAdapter11.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        Log.d("tag", "onCreateViewHolder")

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            itemTitle.text = data[position].title
            itemDetail.text = data[position].desc
            itemImage.setImageResource(data[position].img)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_detail)

        init {
            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()

                Toast.makeText(itemView.context, "hello world $position", Toast.LENGTH_SHORT).show()
            }

        }
    }
}