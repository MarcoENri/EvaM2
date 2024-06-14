package com.example.EvaM2.controller

import com.example.EvaM2.entity.Characters
import com.example.EvaM2.entity.CharactersView
import com.example.EvaM2.entity.Film
import com.example.EvaM2.service.CharactersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/characters")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class CharactersController {
    @Autowired
    lateinit var charactersService: CharactersService

    @GetMapping("/with-scene")
    fun listWithScene(): List<CharactersView> {
        return charactersService.listWithScene()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Characters {
        return charactersService.listById(id)
    }

    @GetMapping
    fun list(): List<Characters> {
        return charactersService.list()
    }

    @PostMapping
    fun save(@RequestBody characters: Characters): Characters {
        return charactersService.save(characters)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody characters: Characters?): ResponseEntity<Characters> {
        val updatedCharacters= charactersService.update(characters!!)
        return ResponseEntity.ok(updatedCharacters)
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: Long?, @RequestBody characters: Characters?): ResponseEntity<Characters> {
        val updatedCharacters = charactersService.updateName(characters!!)
        return ResponseEntity.ok(updatedCharacters)
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
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        charactersService.delete(id)
    }
}