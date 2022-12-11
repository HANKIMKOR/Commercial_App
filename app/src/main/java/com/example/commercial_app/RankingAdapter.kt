package com.example.commercial_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RankingAdapter(private val datas: MutableList<RankingData>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

//        private val txtName: TextView = itemView.findViewById(R.id.tv_rv_name)
//        private val txtAge: TextView = itemView.findViewById(R.id.tv_rv_age)
//        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        private val imgRanking: ImageView = itemView.findViewById(R.id.ranking_photo)
        private val txtName: TextView = itemView.findViewById(R.id.ranking_product_name)
        private val txtPrice: TextView = itemView.findViewById(R.id.ranking_price)

        fun bind(item: RankingData) {
            Glide.with(itemView).load(item.img).into(imgRanking)
            txtName.text = item.name
            txtPrice.text = item.price
        }
    }


}