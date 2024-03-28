package com.example

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymusicapp.Models.Data
import com.example.mymusicapp.R

class MyMusicAdapter(var context:Context,var list:List<Data>):RecyclerView.Adapter<MyMusicAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentitem = list[position]

        var mediaplayer = MediaPlayer.create(context, currentitem.preview!!.toUri())

        Glide.with(context).load(currentitem.album?.cover).into(holder.itemView.findViewById<ImageView>(R.id.image_pic))
 holder.itemView.findViewById<TextView>(R.id.textView).text=currentitem.title
        holder.itemView.findViewById<ImageButton>(R.id.play).setOnClickListener {
            mediaplayer.start()
        }
        holder.itemView.findViewById<ImageButton>(R.id.pause).setOnClickListener {
            mediaplayer.stop()
        }
    }
}