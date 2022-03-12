package com.example.weatherproject.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherproject.R
import com.example.weatherproject.RetrofirHelper
import com.example.weatherproject.RetrofitService
import com.example.weatherproject.model.Hourly
import com.example.weatherproject.model.WeatherModel
import com.example.weatherproject.model.myModel
import kotlinx.coroutines.*
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var hourRecyclerView: RecyclerView
    lateinit var dayRecyclerView: RecyclerView

    var hourlyList = listOf<Hourly>()

    var myModel2 = listOf<myModel>(myModel("Mon","am",temp = "6",img = "0"),
        myModel("Thu","snow",temp = "6/78",img = "0"),
        myModel("Thus","snow",temp = "6/78",img = "0"),
        myModel("Wed","snow",temp = "6/78",img = "0"),
        myModel("Fri","snow",temp = "6/78",img = "0"),)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        hourRecyclerView = view.findViewById(R.id.recyclerView_times)
        hourRecyclerView.setHasFixedSize(true)
        hourRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL ,false)


        dayRecyclerView = view.findViewById(R.id.recyclerView_days)
        dayRecyclerView.setHasFixedSize(true)
        dayRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)

        return view    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hourAdapter = HourTimeAdapter(hourlyList, requireActivity())
        hourRecyclerView.adapter = hourAdapter


        lifecycle.coroutineScope.launch {
            val retrofitService = RetrofirHelper.getInstance().create(RetrofitService::class.java)

            val job : Job = CoroutineScope(Dispatchers.IO).launch {

                var response : Response<WeatherModel> = retrofitService.getAllWeathers()

                withContext(Dispatchers.Main){
                    if (response.isSuccessful){
                        hourlyList = response.body()!!.hourly
                        hourAdapter.hourlyList = hourlyList
                        hourAdapter.notifyDataSetChanged()

                    }else{
                        Toast.makeText(requireContext(),"connection error", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }




        val dayAdapter = DayTimeAdapter(myModel2, requireActivity())
        dayRecyclerView.adapter = dayAdapter



    }

}