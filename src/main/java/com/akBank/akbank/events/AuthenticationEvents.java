package com.akBank.akbank.events;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {

    Logger LOGGER =  LoggerFactory.getLogger(AuthenticationEvents.class);
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        LOGGER.info("Login successful for the user : {}", successEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        LOGGER.error("Login failed for the user : {} due to : {}", failureEvent.getAuthentication().getName(),
                failureEvent.getException().getMessage());
    }

}
