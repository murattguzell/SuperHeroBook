package com.muratguzel.superherobook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class SuperKahramanAdapter(val superKahramanArrayList: ArrayList<SuperKahraman>,viewPager2: ViewPager2) : RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanVH>() {
    class SuperKahramanVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headText: TextView = itemView.findViewById(R.id.headText)
        val detailsText: TextView = itemView.findViewById(R.id.detailsText)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.super_hero_row,parent,false)
        return SuperKahramanVH(itemView)
    }

    override fun getItemCount(): Int {
       return  superKahramanArrayList.size
    }

    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {
        holder.headText.text = superKahramanArrayList.get(position).name
        holder.detailsText.text = superKahramanArrayList.get(position).details
        holder.imageView.setImageResource(superKahramanArrayList.get(position).image)
    }

}