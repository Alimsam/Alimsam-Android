package com.gsm.alimsam.manager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gsm.alimsam.R

class OutingAdapter(context: Context, private val outingList: ArrayList<Outing>) : RecyclerView.Adapter<OutingAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.custom_outing_listview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = outingList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val outing = outingList[position]
        holder.outing_studentName?.text = outing.name
        holder.outing_check?.text = outing.outTime
        holder.outing_inTime?.text = outing.backTime
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val outing_studentName = itemView?.findViewById<TextView?>(R.id.outing_studentName)
        val outing_check = itemView?.findViewById<TextView?>(R.id.outing_outTime)
        val outing_inTime = itemView?.findViewById<TextView?>(R.id.outing_backTime)
    }
}