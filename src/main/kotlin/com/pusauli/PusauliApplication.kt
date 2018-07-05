package com.pusauli

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PusauliApplication

fun main(args: Array<String>) {
    runApplication<PusauliApplication>(*args)
}
