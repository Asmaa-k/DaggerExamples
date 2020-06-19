package com.example.retrofitdagger.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdagger.R
import com.example.retrofitdagger.network.PostModel

class PostAdapter(mData: ArrayList<PostModel>) : RecyclerView.Adapter<PostAdapter.TitleHolder>() {
    private var data: List<PostModel> = ArrayList()
    init {
        this.data = mData
    }

    inner class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.title_txt)
        fun bind(d: PostModel) {
            text.text = d.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.post_title_layout, parent, false)
        return TitleHolder(v)
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: TitleHolder, position: Int) {
        holder.bind(data.get(position))
    }
}