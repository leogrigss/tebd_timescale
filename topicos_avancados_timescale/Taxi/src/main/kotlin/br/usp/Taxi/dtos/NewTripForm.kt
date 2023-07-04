package br.usp.Taxi.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class NewTripForm(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
                       val tpep_pickup_datetime: LocalDateTime,
                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
                       val tpep_dropoff_datetime: LocalDateTime,
                       val passenger_count: Int,
                       val trip_distance: Double,
                       val ratecodeid: Int,
                       val store_and_fwd_flag: Char,
                       val pulocationid: Int,
                       val dolocationid: Int,
                       val payment_type: Int,
                       val fare_amount: Double,
                       val extra: Double,
                       val mta_tax: Double,
                       val tip_amount: Double,
                       val tolls_amount: Double,
                       val improvement_surcharge: Double,
                       val total_amount: Double,
                       val congestion_surcharge: Double,
                       val airport_fee: Double)