package com.akBank.akbank.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.boot.logging.LoggingSystemFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class AuthoritiesLoggingAfterFilter implements Filter {
    /**
     * @param request  The request to process
     * @param response The response associated with the request
     * @param chain    Provides access to the next filter in the chain for this filter to pass the request and response
     *                 to for further processing
     * @throws IOException
     * @throws ServletException
     */
    private static Logger LOGGER = LoggerFactory.getLogger(AuthoritiesLoggingAfterFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null != authentication) {

            LOGGER.info("User " + authentication.getName() + " is successfully authenticated and "
                    + "has the authorities " + authentication.getAuthorities().toString());
        }
        chain.doFilter(request,response);
    }
}
