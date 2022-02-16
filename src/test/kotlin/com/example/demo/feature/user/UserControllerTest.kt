package com.example.demo.feature.user

import com.example.demo.BaseIntegrationTest
import com.jayway.jsonpath.internal.path.PathCompiler.fail
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserControllerTest: BaseIntegrationTest() {

    @Autowired
    lateinit var userController: UserController

    @Test
    fun test() {
        val result = userController.users()
        if (result != null) {
            Assertions.assertFalse(result.isEmpty())
        } else {
            fail("")
        }

    }
}