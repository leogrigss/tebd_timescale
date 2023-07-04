package br.usp.Taxi.Controller

import br.usp.Taxi.Model.TripData
import br.usp.Taxi.Repository.TripRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/trip")
class TripController(private val repo: TripRepo) {

    @GetMapping
    fun listar(): List<TripData> {
        return repo.findBypulocationid(144)
    }

    @GetMapping("/all")
    fun listarTodos(): List<TripData> {
        return repo.findAll()
    }

    @PostMapping
    fun adicionar(@RequestBody trip:TripData) {
        repo.save(trip)
    }
}