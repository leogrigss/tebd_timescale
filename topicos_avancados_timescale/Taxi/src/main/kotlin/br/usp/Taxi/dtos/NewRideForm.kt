package br.usp.Taxi.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class NewRideForm(
        val vendor_id: String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        val pickup_datetime: LocalDateTime,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        val dropoff_datetime: LocalDateTime,
        val passengerCount: Int,
        val tripDistance: Double,
        val pickup_longitude: Double,
        val pickup_latitude: Double,
        val rate_code: Int,
        val dropoff_longitude: Double,
        val dropoff_latitude: Double,
        val payment_type: Int,
        val fare_amount: Double,
        val extra: Double,
        val mta_tax: Double,
        val tip_amount: Double,
        val tolls_amount: Double,
        val improvement_surcharge: Double,
        val total_amount: Double
)