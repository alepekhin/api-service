package com.example.demo.config

import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.filter.CommonsRequestLoggingFilter


@Configuration
class ApplicationConfig {

    @Bean
    fun timedAspect(registry: MeterRegistry): TimedAspect {
        return TimedAspect(registry)
    }

    @Bean
    fun requestLoggingFilter(): CommonsRequestLoggingFilter? {
        val loggingFilter = CommonsRequestLoggingFilter()
        loggingFilter.setIncludeClientInfo(true)
        loggingFilter.setIncludeQueryString(true)
        loggingFilter.setIncludePayload(true)
        loggingFilter.setMaxPayloadLength(64000)
        return loggingFilter
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().build()
    }

}