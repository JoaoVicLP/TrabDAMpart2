package org.example.racas

import java.io.Serializable

interface Raca : Serializable{
    fun serRaca(): String

    fun modRacaForc(): Int

    fun modRacaDest(): Int

    fun modRacaCons(): Int

    fun modRacaInte(): Int

    fun modRacaSabe(): Int

    fun modRacaCari(): Int

}