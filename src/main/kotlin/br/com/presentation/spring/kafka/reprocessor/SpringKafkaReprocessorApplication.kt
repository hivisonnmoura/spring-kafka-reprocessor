package br.com.presentation.spring.kafka.reprocessor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKafkaReprocessorApplication

fun main(args: Array<String>) {
	runApplication<SpringKafkaReprocessorApplication>(*args)
}
