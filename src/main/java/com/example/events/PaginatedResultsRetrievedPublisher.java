package com.example.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class PaginatedResultsRetrievedPublisher {
	    @Autowired
	    private ApplicationEventPublisher applicationEventPublisher;

	    public void publishCustomEvent(final PaginatedResultsRetrievedEvent customSpringEvent) {
	        System.out.println("Publishing custom event. ");
	        applicationEventPublisher.publishEvent(customSpringEvent);
	    }
	}


