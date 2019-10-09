package org.mashup.lottery.util

import java.util.stream.IntStream

object RandomNumberUtil {

    private val container: MutableList<Int> = mutableListOf()

    init {
        IntStream.iterate(4) { it }.limit(5).forEach { container.add(it) }
        IntStream.iterate(5) { it }.limit(5).forEach { container.add(it) }
        IntStream.iterate(6) { it }.limit(20).forEach { container.add(it) }
        IntStream.iterate(7) { it }.limit(20).forEach { container.add(it) }
        IntStream.iterate(8) { it }.limit(50).forEach { container.add(it) }

        container.shuffle()
    }

    fun get(): Int {
        return container[(0 until container.size).random()]
    }
}