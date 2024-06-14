package com.example.EvaM2.repository

import com.example.EvaM2.entity.Scene
import com.example.EvaM2.entity.SceneView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneViewRepository : JpaRepository<SceneView, Long>{
    fun findById (id : Long?) : Scene?
}
