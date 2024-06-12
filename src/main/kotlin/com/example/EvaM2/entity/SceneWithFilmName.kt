package com.example.EvaM2.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
class SceneWithFilmName(
    @Id
    @Column(name = "scene_id")
    val sceneId: Long,

    @Column(name = "scene_description")
    val sceneDescription: String,

    @Column(name = "minutes")
    val minutes: BigDecimal,

    @Column(name = "location")
    val location: String,

    @Column(name = "setting")
    val setting: String,

    @Column(name = "film_title")
    val filmTitle: String
)
