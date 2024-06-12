package com.example.EvaM2.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "characters_with_scene")
class CharactersView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
    var cost: BigDecimal? = null

    @Column(name = "name_actor")
    var nameActor: String? = null
    var rol: String? = null
    var importance: String? = null
@Column(name= "scene_description")
    var sceneDescription: String? = null
}
