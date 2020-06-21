package com.andrewtarry.opsley.backendtest

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.decorators.Decorators
import org.springframework.stereotype.Service
import java.util.function.Supplier

@Service
class Resilient4JDecorator(private val circuitBreakerRegistry: CircuitBreakerRegistry) : ResilientDecorator {

    /**
     * Decorate a supplier function standard resilient config
     */
    override fun <T> decorate(name: String, supplier: () -> List<T>): Supplier<List<T>> {
        return Decorators
                .ofSupplier(supplier)
                .withCircuitBreaker(circuitBreakerRegistry.circuitBreaker(name))
                .withFallback { _: Throwable -> listOf() }
                .decorate()
    }
}