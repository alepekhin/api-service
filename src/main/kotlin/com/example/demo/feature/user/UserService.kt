package com.example.demo.feature.user

import com.example.demo.common.RestHttpClient
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service


@Service
class UserService(
    val httpClient: RestHttpClient
) {

    @Value("\${backend-url}")
    private val backendUrl: String = ""

    fun getUsers() : List<User>? {
        val typeReference: ParameterizedTypeReference<List<User>> =
            object : ParameterizedTypeReference<List<User>>() {}
        return httpClient.getObject("$backendUrl/users", null, typeReference)
    }

}