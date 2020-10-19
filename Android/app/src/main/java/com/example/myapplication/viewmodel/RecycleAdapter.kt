package com.example.myapplication.viewmodel

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import  androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.User
import com.example.myapplication.view.DetailsActivity
import kotlinx.android.synthetic.main.item_layout.view.*


class RecycleAdapter(private val user: List<User>) :
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobNo: TextView = itemView.tv_title
        val truckLicense: TextView = itemView.truckLicense
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val users = user[position]
        holder.jobNo.text = users.jobNo
        holder.truckLicense.text = users.truckLicense

        holder.itemView.setOnClickListener {
            Log.d(TAG, "onItemClick for ID: " + holder.jobNo)

            val context = holder.itemView.context as Activity
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("jobNo", users.jobNo)
            intent.putExtra("truckLicense", users.truckLicense)
            intent.putExtra("province", users.province)
            intent.putExtra("truckType", users.truckType)
            intent.putExtra("routeDt", users.routeDt)
            intent.putExtra("routeCd", users.routeCd)
            intent.putExtra("logisticPointCd", users.logisticPointCd)
            intent.putExtra("arrivalDt", users.arrivalDt)
            intent.putExtra("departureDt", users.departureDt)


            context.startActivity(intent)

        }
    }
}



