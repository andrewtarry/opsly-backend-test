package com.andrewtarry.opsley.backendtest

import com.fasterxml.jackson.databind.ObjectMapper
import feign.codec.Decoder
import feign.jackson.JacksonDecoder
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import java.time.Duration

@SpringBootApplication
@EnableFeignClients
class BackendTestApplication {

    companion object {
        const val DOMAIN = "https://takehome.io/"
    }

    @Bean
    fun circuitBreakerConfig(): CircuitBreakerConfig = CircuitBreakerConfig
            .custom()
            .failureRateThreshold(20F)
            .slowCallDurationThreshold(Duration.ofSeconds(10))
            .slidingWindowSize(3)
            .build()

    @Bean
    fun circuitBreakerRegistry(config: CircuitBreakerConfig): CircuitBreakerRegistry = CircuitBreakerRegistry.of(config)

    @Bean
    fun decoder(objectMapper: ObjectMapper): Decoder = JacksonDecoder(objectMapper)

}

fun main(args: Array<String>) {
    runApplication<BackendTestApplication>(*args)
}
