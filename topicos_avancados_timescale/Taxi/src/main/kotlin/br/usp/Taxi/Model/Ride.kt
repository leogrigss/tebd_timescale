package br.usp.Taxi.Model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.cglib.core.Local
import java.time.LocalDateTime

@Entity
data class Ride(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial")
        val id: Long? = null,
        val vendor_id: String,
        val pickup_datetime: LocalDateTime,
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