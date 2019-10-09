package org.mashup.lottery.storage

import org.mashup.lottery.entity.Crew
import java.io.File
import java.util.stream.IntStream

object CrewStorage {

    private val container: MutableMap<Int, MutableList<Crew>> = mutableMapOf()

    fun load() {
        initContainer()

        File("/Users/hubert.squid/dev/mashup/lottery/src/main/resources/data/crews.txt").forEachLine {
            val line = it.split(",")
            val crew = Crew(name = line[0], grade = line[1].toInt(), team = line[2])

            container[crew.grade]!!.add(crew)
        }
    }

    private fun initContainer() {
        IntStream.iterate(4) { it + 1 }
                .limit(5)
                .forEach { container[it] = mutableListOf() }
    }

    fun get(index: Int): List<Crew> {
        return synchronized(container) { container[index]!! }
    }

    fun replace(index: Int, element: List<Crew>) {
        return synchronized(container) { container[index] = element.toMutableList() }
    }
}