package com.example.EvaM2.repository

import com.example.EvaM2.entity.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository : JpaRepository<Film, Long> {
    fun findById (id : Long?) : Film
}
