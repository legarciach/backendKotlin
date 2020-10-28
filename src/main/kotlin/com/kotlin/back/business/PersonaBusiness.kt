package com.kotlin.back.business

import com.kotlin.back.entity.Persona
import com.kotlin.back.exception.BusinessException
import com.kotlin.back.exception.NotFoundException
import com.kotlin.back.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaBusiness: IPersonaBusiness {

    @Autowired
    val personaRepository: PersonaRepository?= null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try {
            return personaRepository!!.findAll()
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>

        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con id $idPersona")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        try {
            return personaRepository!!.save(persona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
            if(!op.isPresent){
                throw NotFoundException("No se encontro la persona con id $idPersona")
            }else{
                try {
                    personaRepository!!.delete(op.get())
                }catch (e:java.lang.Exception){
                    BusinessException(e.message)
                }
            }
        }catch (e: BusinessException){
            throw BusinessException(e.message)
        }
    }
}