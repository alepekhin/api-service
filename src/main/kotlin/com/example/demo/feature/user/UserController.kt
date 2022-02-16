package com.example.demo.feature.user

import com.example.demo.model.User
import io.leangen.graphql.annotations.GraphQLQuery
import io.micrometer.core.annotation.Timed
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(
    val userService: UserService
) {

    @QueryMapping
    @Timed("users")
    @GraphQLQuery(name = "users")
    fun users(): List<User>? {
        return userService.getUsers()
    }

}