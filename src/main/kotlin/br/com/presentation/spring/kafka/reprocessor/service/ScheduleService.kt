package br.com.presentation.spring.kafka.reprocessor.service

import br.com.presentation.spring.kafka.reprocessor.producer.KafkaProducer
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@EnableScheduling
@Configuration
class ScheduleService(
        private val kafkaProducer: KafkaProducer
) {
    @Scheduled(fixedDelay = 60000)
    fun producerSchedule() {
        kafkaProducer.produceToKafka()
    }
}