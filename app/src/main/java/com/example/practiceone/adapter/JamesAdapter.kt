package com.example.practiceone.adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceone.R
import com.example.practiceone.model.Affirmation

class JamesAdapter(private val context: Context?, private val imageSet: ArrayList<Affirmation>) : RecyclerView.Adapter<JamesAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.ivWebbImage) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.jameswebb_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageBytes = Base64.decode(imageSet[position].base64Image, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        holder.imageView.setImageBitmap(decodedImage)
        holder.imageView.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(imageSet[position].linkToArticle)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount() = imageSet.size
}