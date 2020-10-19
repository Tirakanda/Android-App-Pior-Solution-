package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_details.*
import java.time.*
import java.time.format.DateTimeFormatter

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        var date = LocalDate.parse("2018-12-31 09:30")
//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm")
//        var formattedDate = date.format(formatter)
//        d("formatter.format(now)",formattedDate)

        val jobnoData = intent.getStringExtra("jobNo")
        val truckLicenseData = intent.getStringExtra("truckLicense")
        val provinceData = intent.getStringExtra("province")
        val truckTypeData = intent.getStringExtra("truckType")
        val routeDtData = intent.getStringExtra("routeDt")
        val routeCdData = intent.getStringExtra("routeCd")
        val logisticPointCdData = intent.getStringExtra("logisticPointCd")
        val arrivalDtData = intent.getStringExtra("arrivalDt")
        val departureDtData = intent.getStringExtra("departureDt")


        val Dtroute = routeDtData
        val formatterDtroute = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val firstdate = formatterDtroute.parse(Dtroute)
        val routeDtDataFormat = DateTimeFormatter.ofPattern("dd MMM yyyy").format(firstdate)
        d("formatter.format(now)", routeDtDataFormat)


        val second = LocalDateTime.parse(arrivalDtData, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))
        val arrivalDtDataFormat = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm").format(second)
        d("formatter.format(23)", arrivalDtDataFormat)


        val third = LocalDateTime.parse(departureDtData, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))
        val departureDtDataFormat = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm").format(third)
        d("formatter.format(23)", departureDtDataFormat)


        jobno.text = jobnoData
        truckLicense.text = truckLicenseData
        province.text = provinceData
        truckType.text = truckTypeData
        routeDt.text = routeDtDataFormat
        routeCd.text = routeCdData
        logisticPointCd.text = logisticPointCdData
        arrivalDt.text = arrivalDtDataFormat
        departureDt.text = departureDtDataFormat

    }
}
