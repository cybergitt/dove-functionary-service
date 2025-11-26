package com.sinodash.getdovenote.api.functionary_service.common.logging;

import java.io.IOException;
import java.util.UUID;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Order(Integer.MIN_VALUE) // Ensure this filter runs early in the chain
public class RequestLoggingFilter implements Filter {

    private static final String TRACE_ID = "traceId";
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // Generate a unique ID for each request and put it in the MDC (ThreadContext)
            String traceId = UUID.randomUUID().toString();
            ThreadContext.put(TRACE_ID, traceId);
            
            // Log request details (optional, other logging will pick up the MDC value)
            if (request instanceof HttpServletRequest httpRequest) {
                // We can add more context like IP address, user details, etc.
                ThreadContext.put("clientIp", httpRequest.getRemoteAddr());
            }

            // Proceed with the rest of the application's filters and servlets
            chain.doFilter(request, response);
        } finally {
            // IMPORTANT: Clear the MDC after the request is processed to prevent 
            // context leakage into other requests when using thread pools
            ThreadContext.clearAll(); 
        }
    }
}
