package example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import example.com.kotlin_android_api_tutorial.R

class SoundMVCAdapter(val beatBox: BeatBox) : RecyclerView.Adapter<SoundMVCAdapter.SoundHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): SoundHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_sound_button, viewGroup, false)
        return SoundHolder(v)
    }

    override fun getItemCount(): Int {
        return beatBox.sounds.size
    }

    override fun onBindViewHolder(soundHolder: SoundHolder, position: Int) {
        soundHolder.bindSound(beatBox.sounds[position])
    }




    inner class SoundHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var btn: Button = itemView as Button
        var sound: Sound? = null

        fun bindSound(sound: Sound){
            this.sound = sound
            btn.text = sound.name
            btn.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if(sound != null) {
                beatBox.play(sound!!)
            }
        }

    }
}