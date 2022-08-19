package com.wiprotask.telstra

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wiprotask.telstra.databinding.ItemCardmainBinding


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var facts = mutableListOf<Fact>()
    fun setFactList(fact: List<Fact>) {
        this.facts = fact.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardmainBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    // here title , description and image poster are set into their view.
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val fact = facts[position]
        if(fact.title != null){
            holder.binding.tvTitle.text = fact.title
        }else{
            holder.binding.tvTitle.text = "No Title Available"
        }
        if(fact.description != null){
            holder.binding.tvDescription.text = fact.description
        }else{
            holder.binding.tvDescription.text = "No Description Available"
        }
        Glide.with(holder.itemView.context).load(fact.poster).placeholder(R.drawable.bg_card_list).error(R.drawable.img_error).into(holder.binding.imgImageHref)
    }

    override fun getItemCount(): Int {
        return facts.size
    }
}

class MainViewHolder(val binding: ItemCardmainBinding) : RecyclerView.ViewHolder(binding.root) {

}