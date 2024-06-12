package com.example.EvaM2.service

import com.example.EvaM2.entity.Film
import com.example.EvaM2.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class FilmService {


    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Film> {
        return filmRepository.findAll()
    }

    fun save(film: Film): Film {
        return filmRepository.save(film)
    }

    fun update(film: Film): Film {
        try {
            filmRepository.findById(film.id)
                ?: throw Exception("Ya existe el id")
            return filmRepository.save(film)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(film: Film): Film? {
        try {
            var response = filmRepository.findById(film.id)
                ?: throw Exception("Ya existe el id")
            response.apply {
                id= film.id
            }
            return filmRepository.save (response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
