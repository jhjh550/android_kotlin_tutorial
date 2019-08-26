package example.com.kotlin_android_api_tutorial.T24_SoundPool_MVVM

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import example.com.kotlin_android_api_tutorial.R
import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.BeatBox
import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.Sound
import example.com.kotlin_android_api_tutorial.databinding.ItemSoundButtonMvvmBinding
import example.com.kotlin_android_api_tutorial.viewmodel.SoundViewModel


class SoundMVVMAdapter(val beatBox: BeatBox): RecyclerView.Adapter<SoundMVVMAdapter.SoundMVVMHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): SoundMVVMHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
//        val binding = ItemSoundButtonMvvmBinding.inflate(inflater)
        val binding = DataBindingUtil.inflate<ItemSoundButtonMvvmBinding>(
                                inflater,
            R.layout.item_sound_button_mvvm, viewGroup,false)
        return SoundMVVMHolder(binding)
    }

    override fun getItemCount(): Int {
        return beatBox.sounds.size
    }

    override fun onBindViewHolder(holder: SoundMVVMHolder, position: Int) {
        holder.bind(beatBox.sounds[position])
    }

    inner class SoundMVVMHolder(val binding: ItemSoundButtonMvvmBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.viewModel = SoundViewModel(beatBox)
        }

        fun bind(sound: Sound){
            Log.d("bind", sound.name)
            binding.viewModel?.sound = sound
            binding.executePendingBindings()
        }
    }
}