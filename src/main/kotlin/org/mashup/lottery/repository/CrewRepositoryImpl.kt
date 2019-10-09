package org.mashup.lottery.repository

import org.mashup.lottery.entity.Crew
import org.mashup.lottery.storage.CrewStorage
import org.springframework.stereotype.Repository

@Repository
class CrewRepositoryImpl : CrewRepository {

    override fun findByGrade(grade: Int): List<Crew> {
        return CrewStorage.get(grade)
    }

    override fun updateByGrade(grade: Int, crews: List<Crew>) {
        CrewStorage.replace(grade, crews)
    }
}