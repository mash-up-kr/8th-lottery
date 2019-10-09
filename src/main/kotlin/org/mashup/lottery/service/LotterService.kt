package org.mashup.lottery.service

import org.mashup.lottery.entity.Crew
import org.mashup.lottery.repository.CrewRepository
import org.mashup.lottery.util.RandomNumberUtil
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class LotterService(private val crewRepository: CrewRepository) {

    companion object {
        val logger = LoggerFactory.getLogger(LotterService::class.java)
    }

    fun extract(): Crew {
        val grade = RandomNumberUtil.get()
        val crews = retryRead { crewRepository.findByGrade(grade) }
        crews.shuffle()

        val result = crews.removeAt(0)

        crewRepository.updateByGrade(grade, crews)

        return result
    }

    private fun retryRead(f: () -> List<Crew>): MutableList<Crew> {
        lateinit var crews: MutableList<Crew>

        do {
            crews = f().toMutableList()
            logger.info("list size : ${crews.size}")
        } while (crews.isEmpty())

        return crews
    }
}