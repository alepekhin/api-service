package com.example.demo.common

import org.slf4j.MDC
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class RestHttpClient(
    val restTemplate: RestTemplate
) {
    fun <T> getObject(url: String, token: String?, typeReference: ParameterizedTypeReference<T>): T? {
        val response: ResponseEntity<T> =
            restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(token, null), typeReference)
        return response.body
    }

    private fun createHttpEntity(token: String?, `object`: Any?): HttpEntity<*>? {
        val headers = HttpHeaders()
        if (token != null) {
            headers.set("Authorization", "Bearer $token")
        }
        headers.set(Constants.X_REQUEST_ID, MDC.get(Constants.MDC_RQID))
        return `object`?.let { HttpEntity(it, headers) } ?: HttpEntity<Any?>(headers)
    }

}