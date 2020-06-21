package com.andrewtarry.opsley.backendtest

import java.util.function.Supplier

interface ResilientDecorator {

    /**
     * Decorate a supplier function standard resilient config
     */
    fun <T> decorate(name: String, supplier: () -> List<T>): Supplier<List<T>>
}