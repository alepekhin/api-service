package com.example.demo.feature.greeting

import com.example.demo.BaseIntegrationTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class GreetingControllerTest: BaseIntegrationTest() {

    @Autowired
    lateinit var greetingController: GreetingController

    @Test
    fun test() {
        val result = greetingController.greeting()
        assertEquals("Hello", result)
    }

}