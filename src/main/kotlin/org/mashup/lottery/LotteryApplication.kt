package org.mashup.lottery

import org.mashup.lottery.storage.CrewStorage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LotteryApplication

fun main(args: Array<String>) {
	CrewStorage.load()
	runApplication<LotteryApplication>(*args)
}
