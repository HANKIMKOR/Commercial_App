package com.example.commercial_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SearchAdapter(private val searchList: ArrayList<SearchData>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.search_recycler, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = searchList[position]

        holder.txtName.text = currentItem.name
        holder.txtPrice.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtName: TextView = itemView.findViewById(R.id.search_name)
        val txtPrice: TextView = itemView.findViewById(R.id.search_price)

    }

}

