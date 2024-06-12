package com.example.EvaM2.controller

import com.example.EvaM2.entity.Characters
import com.example.EvaM2.service.CharactersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/characters")
class CharactersController {
    @Autowired
    lateinit var charactersService: CharactersService

    @GetMapping
    fun list(): List<Characters> {
        return charactersService.list()
    }

    @PostMapping
    fun save(@RequestBody characters: Characters): Characters {
        return charactersService.save(characters)
    }

    @PutMapping
    fun update(@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.update(characters), HttpStatus.OK)
    }

    @PatchMapping
    fun patch(@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.updateName(characters), HttpStatus.OK)
    }

    @GetMapping("/validateCost/{filmId}")
    fun validateCostAgainstFilmDuration(@PathVariable filmId: Long): ResponseEntity<String> {
        try {
            charactersService.validateCostAgainstFilmDuration(filmId)
            return ResponseEntity.ok("El costo total de los personajes no excede la duración de la película.")
        } catch (ex: Exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
        }
    }
}
