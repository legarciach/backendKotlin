package com.kotlin.back.entity

import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = "personas")
data class Persona (val dni:Long =0, val nombre:String = "", val apellido:String = "", val fechaNac:LocalDate?= null){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0

}