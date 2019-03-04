package example.com.kotlin_android_api_tutorial.T06_CustomListView

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import example.com.kotlin_android_api_tutorial.R
import example.com.kotlin_android_api_tutorial.R.*
import example.com.kotlin_android_api_tutorial.T06_CustomListView.CustomListViewActivity.MyData
import kotlinx.android.synthetic.main.activity_custom_list_view.*


class CustomListViewActivity : AppCompatActivity() {

    data class MyData(var title: String, var desc: String, var imgIcon: Int)

    var myList = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_custom_list_view)
        for(i in 0..100){
            myList.add(MyData("title $i", "desc $i", R.mipmap.ic_launcher))
        }
        val adapter = CustomListAdapter(this, myList)
        myCustomListView.adapter = adapter

    }

    class CustomListAdapter(private val context: Context,
                            private val dataSource:ArrayList<MyData>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val v = LayoutInflater.from(context).inflate(R.layout.item_custom_listview, parent, false)

            val textViewTitle = v.findViewById<TextView>(R.id.textViewTitle)
            val textViewDesc = v.findViewById<TextView>(R.id.textViewDesc)
            val imageView = v.findViewById<ImageView>(R.id.item_icon)

            val myData = dataSource[position]
            textViewTitle.setText(myData.title)
            textViewDesc.setText(myData.desc)
            imageView.setImageResource(myData.imgIcon)

            return v
        }

        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return dataSource.size
        }
    }
}
