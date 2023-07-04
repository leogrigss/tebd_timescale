package br.usp.Taxi.Controller

import br.usp.Taxi.Model.Ride
import br.usp.Taxi.Repository.RideRepo
import br.usp.Taxi.dtos.NewRideForm
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rides")
class RideController(private val repo: RideRepo) {

    @GetMapping
    fun list(): MutableList<Ride> {
        return repo.findAll()
    }

    @PostMapping
    @Transactional
    fun inserir(@RequestBody form: NewRideForm) {
        repo.save(Ride(
            null,
            form.vendor_id,
            form.pickup_datetime,
            form.dropoff_datetime,
            form.passengerCount,
            form.tripDistance,
            form.pickup_longitude,
            form.pickup_latitude,
            form.rate_code,
            form.dropoff_longitude,
            form.dropoff_latitude,
            form.payment_type,
            form.fare_amount,
            form.extra,
            form.mta_tax,
            form.tip_amount,
            form.tolls_amount,
            form.improvement_surcharge,
            form.total_amount
        ))
    }
}