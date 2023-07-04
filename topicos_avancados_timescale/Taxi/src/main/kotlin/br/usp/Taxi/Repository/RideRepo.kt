package br.usp.Taxi.Repository

import br.usp.Taxi.Model.Ride
import org.springframework.data.jpa.repository.JpaRepository


interface RideRepo: JpaRepository<Ride, Long>