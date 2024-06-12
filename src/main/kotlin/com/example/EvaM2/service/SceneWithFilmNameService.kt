package com.example.EvaM2.service

import com.example.EvaM2.entity.SceneWithFilmName
import com.example.EvaM2.repository.SceneWithFilmNameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SceneWithFilmNameService {

    @Autowired
    lateinit var sceneWithFilmNameRepository: SceneWithFilmNameRepository

    fun list(): List<SceneWithFilmName> {
        return sceneWithFilmNameRepository.findAll()
    }
}
