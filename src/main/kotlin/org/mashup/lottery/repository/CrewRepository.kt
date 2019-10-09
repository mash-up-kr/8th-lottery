package org.mashup.lottery.repository

import org.mashup.lottery.entity.Crew

interface CrewRepository {

    fun findByGrade(grade: Int): List<Crew>
    fun updateByGrade(grade: Int, crews: List<Crew>)
}