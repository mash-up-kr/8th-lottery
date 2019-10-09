package org.mashup.lottery

import org.junit.Assert
import org.junit.Test
import org.mashup.lottery.storage.CrewStorage
import java.util.stream.IntStream

class CrewStorageTest {

    @Test
    fun intStreamTest() {
        IntStream.iterate(4) { it }
                .limit(5)
                .forEach { println(it) }
    }

    @Test
    fun loadTest() {
        CrewStorage.load()
        Assert.assertEquals(28, CrewStorage.get(8).size)
    }
}