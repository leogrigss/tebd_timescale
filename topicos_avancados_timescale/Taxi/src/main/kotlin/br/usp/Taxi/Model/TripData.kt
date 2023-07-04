package br.usp.Taxi.Model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class TripData(
        @Id
        val tpep_pickup_datetime: LocalDateTime,
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
        val airport_fee: Double
)