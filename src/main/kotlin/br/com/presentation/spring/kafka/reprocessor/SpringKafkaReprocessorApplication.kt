package br.com.presentation.spring.kafka.reprocessor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class SpringKafkaReprocessorApplication

fun main(args: Array<String>) {
	runApplication<SpringKafkaReprocessorApplication>(*args)
}
