package br.com.presentation.spring.kafka.reprocessor.controller

import org.springframework.http.ResponseEntity
import org.springframework.kafka.config.KafkaListenerEndpointRegistry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContainerController(
        private val endpointRegistry: KafkaListenerEndpointRegistry
) {

    @GetMapping
    fun helloWorld() = "Hello World"

    @GetMapping("/restart")
    fun restartKafkaContainer(): ResponseEntity<String> {
        endpointRegistry.getListenerContainer("kafkareset-test").stop()
        endpointRegistry.getListenerContainer("kafkareset-test").start()
        return ResponseEntity.ok().build()
    }
}