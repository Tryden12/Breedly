package com.tryden.breedly.domain

interface Mapper<T : Any, Model: Any> {
    fun buildFrom(value: Model): T
}