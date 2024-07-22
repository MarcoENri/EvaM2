package com.example.EvaM2.repository

import com.example.EvaM2.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneRepository : JpaRepository<Scene, Long> {
    fun findById (id : Long?) : Scene?
    fun findByFilmId (id : Long?) : List<Scene>
}