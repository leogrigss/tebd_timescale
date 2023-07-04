package br.usp.Taxi.Repository

import br.usp.Taxi.Model.TripData
import org.springframework.data.jpa.repository.JpaRepository

interface TripRepo: JpaRepository<TripData, Long> {

    fun findBypulocationid(value: Int): List<TripData>
}
