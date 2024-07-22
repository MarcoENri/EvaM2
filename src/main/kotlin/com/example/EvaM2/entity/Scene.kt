package com.example.EvaM2.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
    var minutes: BigDecimal? = null
    var location: String? = null
    var setting: String? = null


    @Column(name = "film_id")
    var filmId:Long? = null
}
