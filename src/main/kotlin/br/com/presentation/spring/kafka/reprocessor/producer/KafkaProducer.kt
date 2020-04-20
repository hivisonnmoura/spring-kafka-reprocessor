package br.com.presentation.spring.kafka.reprocessor.producer

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class KafkaProducer(
        private val kafkaTemplate: KafkaTemplate<String, String>,
        @Value("\${spring.kafka.producer.topicName}") private val topicName: String
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun produceToKafka() {
        for (i in 1..1000) {
            val date = Instant.now().toString()
            logger.info("Sending date to kafka : $date")
            kafkaTemplate.send(topicName, date)
        }
    }
}