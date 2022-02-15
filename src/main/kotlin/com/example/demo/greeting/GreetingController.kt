package com.example.demo.greeting

import io.leangen.graphql.annotations.GraphQLQuery
import io.micrometer.core.annotation.Timed
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class GreetingController {

    // In Postman:
    // POST localhost:8080/graphql
    // query {
    //    greeting
    // }
    // Open in browser
    // http://localhost:8080/actuator/metrics/greeting

    @QueryMapping
    @Timed("greeting")
    @GraphQLQuery(name = "user")
    fun greeting():String {
        Thread.sleep(2000)
        return "Hello";
    }

}