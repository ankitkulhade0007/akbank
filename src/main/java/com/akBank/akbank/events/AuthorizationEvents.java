package com.akBank.akbank.events;

import com.akBank.akbank.filter.AuthoritiesLoggingAtFilter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorizationEvents {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthorizationEvents.class);
    @EventListener
    public void onFailure(AuthorizationDeniedEvent deniedEvent) {
        LOGGER.error("Authorization failed for the user : {} due to : {}", deniedEvent.getAuthentication().get().getName(),
                deniedEvent.getAuthorizationDecision().toString());
    }

}
