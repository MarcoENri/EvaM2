package com.example.EvaM2.controller

import com.example.EvaM2.entity.Scene
import com.example.EvaM2.entity.SceneView
import com.example.EvaM2.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController

@RequestMapping("/scene")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class SceneController {
    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping("/withFilmName")
    fun listWithFilm(): ResponseEntity<List<SceneView>> {
        val scenes = sceneService.listWithFilm()
        return ResponseEntity(scenes, HttpStatus.OK)
    }

    @GetMapping
    fun list(): List<Scene>{
        return sceneService.list()
    }

    @PostMapping
    fun save(@RequestBody scene: Scene): Scene{
        return sceneService.save(scene)
    }

    @PutMapping
    fun update(@RequestBody scene: Scene): ResponseEntity<Scene>{
        return ResponseEntity(sceneService.update(scene), HttpStatus.OK)
    }

    @PatchMapping
    fun patch(@RequestBody scene: Scene): ResponseEntity<Scene>{
        return ResponseEntity(sceneService.updateName(scene), HttpStatus.OK)
    }
}
