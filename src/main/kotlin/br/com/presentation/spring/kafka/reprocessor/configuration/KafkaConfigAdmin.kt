package br.com.presentation.spring.kafka.reprocessor.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaConfigAdmin {

    fun kafkaRewindTopic(admin: KafkaAdmin) =
            NewTopic("KafkaRewind",1,1)
}