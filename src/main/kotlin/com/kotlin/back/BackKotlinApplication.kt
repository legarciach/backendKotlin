package com.kotlin.back

import com.kotlin.back.entity.Persona
import com.kotlin.back.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class BackKotlinApplication: CommandLineRunner{
    @Autowired
    val personaRepository:PersonaRepository?=null

    override fun run(vararg args: String?) {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val persona1 = Persona(56898457, "Enrique", "Garcia", LocalDate.parse("06/04/1984", formatter))
        personaRepository!!.save(persona1)
    }
}

fun main(args: Array<String>) {
    runApplication<BackKotlinApplication>(*args)
}
