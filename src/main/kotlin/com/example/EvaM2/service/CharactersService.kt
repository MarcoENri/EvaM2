package com.example.EvaM2.service

import com.example.EvaM2.entity.Characters
import com.example.EvaM2.entity.CharactersView
import com.example.EvaM2.repository.CharactersRepository
import com.example.EvaM2.repository.CharactersViewRepository
import com.example.EvaM2.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.math.BigDecimal

@Service
class CharactersService {

    @Autowired
    lateinit var charactersRepository: CharactersRepository
    @Autowired
    lateinit var charactersViewRepository: CharactersViewRepository

    @Autowired
    lateinit var filmRepository: FilmRepository

    fun listWithScene(): List<CharactersView> {
        return charactersViewRepository.findAll()
    }

    fun list(): List<Characters> {
        return charactersRepository.findAll()
    }

    fun save(characters: Characters): Characters {
        return charactersRepository.save(characters)
    }

    fun update(characters: Characters): Characters {
        try {
            charactersRepository.findById(characters.id)
                ?: throw Exception("Ya existe el id")
            return charactersRepository.save(characters)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(characters: Characters): Characters? {
        try {
            var response = charactersRepository.findById(characters.id)
                ?: throw Exception("Ya existe el id")
            response.apply {
                id = characters.id
            }
            return charactersRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun validateCostAgainstFilmDuration(filmId: Long) {
        val film = filmRepository.findById(filmId)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Film not found") }

        val totalMinutes = charactersRepository.sumMinutesByFilmId(filmId)
            ?: BigDecimal.ZERO

        if (totalMinutes > film.duration) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "El costo total de los personajes supera la duración de la película.")
        }
    }
}