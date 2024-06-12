package com.example.EvaM2.repository

import com.example.EvaM2.entity.Characters
import com.example.EvaM2.entity.CharactersView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface CharactersViewRepository : JpaRepository<CharactersView, Long> {
    fun findById(id: Long?): Characters?

}