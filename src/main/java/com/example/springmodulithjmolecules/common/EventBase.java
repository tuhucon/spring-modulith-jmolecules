package com.example.springmodulithjmolecules.common;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public abstract class EventBase extends ApplicationEvent {

    @Getter
    private String eventId;

    public EventBase(Object source) {
        super(source);
        eventId = Generators.timeBasedEpochGenerator().generate().toString(); //UUID v7
    }
}
