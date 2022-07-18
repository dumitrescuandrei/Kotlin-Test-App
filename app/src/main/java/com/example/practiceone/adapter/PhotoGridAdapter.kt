package com.example.practiceone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.practiceone.R
import com.example.practiceone.data.MarsPhoto
import com.example.practiceone.databinding.RemoteCardBinding
import com.example.practiceone.model.Affirmation

class PhotoGridAdapter (private val context: Context?, private val imageSet: List<MarsPhoto>?) : RecyclerView.Adapter<PhotoGridAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.ivRemoteImage) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.remote_card, parent, false))
    }

    override fun getItemCount(): Int {
        if(imageSet == null) {
            return 0
        }
        else {
            return imageSet.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUri = imageSet?.get(position)?.imgSrcUrl?.toUri()?.buildUpon()?.scheme("https")?.build()
        holder.imageView.load(imgUri)
    }

}