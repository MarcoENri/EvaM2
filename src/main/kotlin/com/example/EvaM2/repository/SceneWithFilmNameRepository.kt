package com.example.EvaM2.repository

import com.example.EvaM2.entity.SceneWithFilmName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneWithFilmNameRepository : JpaRepository<SceneWithFilmName, Long>
