package com.kotlin.back.business

import com.kotlin.back.entity.Persona

interface IPersonaBusiness {

    fun list(): List<Persona>
    fun load(idPersona:Long): Persona
    fun save(persona: Persona): Persona
    fun remove(idPersona: Long)


}