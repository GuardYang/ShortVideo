package com.ysr.shortvideo.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ysr.shortvideo.R
import com.ysr.shortvideo.bean.MenuBean

/**
 * @author by yangshirong on 2017/11/8 下午8:47.
 * 邮箱 yfeng1023@gmail.com
 */
class MenuAdapter(val context: Context, val data: List<MenuBean>?) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    var listener: ItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.txt_tab.text = data!![position]!!.title
        Glide.with(context)
                .load(data!![position].iconId)
                .into(holder.img_tab)
        if (null != listener) {
            holder.cl_base.setOnClickListener {
                listener!!.itemClick(holder.cl_base,position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_menu, null))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cl_base: ConstraintLayout = itemView.findViewById<ConstraintLayout>(R.id.cl_base)
        var img_tab: ImageView = itemView.findViewById<ImageView>(R.id.img_tab)
        var txt_tab: TextView = itemView.findViewById<TextView>(R.id.txt_tab)

    }

    fun setOnItemClickListener(listener: ItemClickListener) {
        this.listener = listener

    }

    interface ItemClickListener {
        fun itemClick(view: View, position: Int)
    }
}