package com.example.weatherproject.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherproject.R
import com.example.weatherproject.model.Hourly

class HourTimeAdapter( var hourlyList: List<Hourly>, private val context: Context)
    : RecyclerView.Adapter<HourTimeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourTimeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_weather_item, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: HourTimeAdapter.ViewHolder, position: Int) {

        var Hourly = hourlyList[position]

        holder.clouds.text = Hourly.clouds.toString()
        holder.windDeg.text = Hourly.wind_deg.toString()
        holder.wind_gust.text =Hourly.wind_gust.toString()

        //Glide.with(context).load(myModel.img).into(holder.imgIcon)

    }

    override fun getItemCount() = hourlyList.size



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var clouds: TextView = itemView.findViewById(R.id.txt_time_number)
        var windDeg: TextView = itemView.findViewById(R.id.txt_time_am)
        var wind_gust: TextView = itemView.findViewById(R.id.txt_temp_number)
        var dewPoint: TextView = itemView.findViewById(R.id.txt_time_am)
        var feels_like: ImageView = itemView.findViewById(R.id.iv_ic_cloudy)
        var dt: TextView = itemView.findViewById(R.id.txt_temp_number)
        var humidity: TextView = itemView.findViewById(R.id.txt_temp_number)
        var pop: TextView = itemView.findViewById(R.id.txt_temp_number)
        var pressure: TextView = itemView.findViewById(R.id.txt_temp_number)
        var rain: TextView = itemView.findViewById(R.id.txt_temp_number)
        var temp: TextView = itemView.findViewById(R.id.txt_temp_number)
        var uvi: TextView = itemView.findViewById(R.id.txt_temp_number)
        var visibility: TextView = itemView.findViewById(R.id.txt_temp_number)
        var weather: TextView = itemView.findViewById(R.id.txt_temp_number)
        var wind_speed: TextView = itemView.findViewById(R.id.txt_temp_number)
    }


}