package com.example.weatherproject.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherproject.R
import com.example.weatherproject.model.myModel

class DayTimeAdapter( var myModelList: List<myModel>, private val context: Context)
    : RecyclerView.Adapter<DayTimeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayTimeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_weather_item, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: DayTimeAdapter.ViewHolder, position: Int) {

        var myModel = myModelList[position]

        holder.txtDay.text = myModel.hour
        holder.txtDayStats.text = myModel.am
        holder.txtDayTemp.text =myModel.temp

        Glide.with(context).load(myModel.img).into(holder.imgIcon)

    }

    override fun getItemCount() = myModelList.size



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtDay: TextView = itemView.findViewById(R.id.txt_day)
        var txtDayStats: TextView = itemView.findViewById(R.id.txt_day_state)
        var imgIcon: ImageView = itemView.findViewById(R.id.iv_day_weather)
        var txtDayTemp: TextView = itemView.findViewById(R.id.txt_day_weather_num)
    }


}