package br.com.presentation.spring.kafka.reprocessor.consumer

import org.apache.kafka.common.TopicPartition
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.ConsumerSeekAware
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.concurrent.TimeUnit

@Service
class KafkaConsumer : ConsumerSeekAware {

    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(
            id = "kafkareset-test",
            topics = ["KafkaRewind"]
    )
    fun consumer(@Payload event: String, @Header(KafkaHeaders.OFFSET) offset: Long) {
        logger.info("Message consumed: $event and offset $offset")
    }

    override fun onPartitionsAssigned(assignments: MutableMap<TopicPartition, Long>?, callback: ConsumerSeekAware.ConsumerSeekCallback?) {
        val rewindTo = Instant.now().minusMillis(TimeUnit.SECONDS.toMillis(30)).toEpochMilli()
        callback?.seekToTimestamp(assignments?.keys, rewindTo)

    }
}
