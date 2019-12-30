package com.gsm.alimsam.manager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gsm.alimsam.R

class MovingAdapter(context: Context, private val movingList: ArrayList<Moving>) : RecyclerView.Adapter<MovingAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.custom_moving_listview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = movingList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val moving = movingList[position]
        holder.moving_studentName?.text = moving.name
        holder.moving_studentLocation?.text = moving.place
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val moving_studentName = itemView?.findViewById<TextView?>(R.id.moving_studentName)
        val moving_studentLocation = itemView?.findViewById<TextView?>(R.id.moving_studentLocation)
    }

}