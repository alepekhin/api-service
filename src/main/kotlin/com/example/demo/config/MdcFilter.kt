package com.example.demo.config

import com.example.demo.common.Constants
import org.slf4j.MDC
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.*
import javax.servlet.*


@Component
class MdcFilter: Filter {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
        MDC.put(Constants.MDC_RQID, UUID.randomUUID().toString().replace("-", ""))
        chain.doFilter(request, response)
    }

}