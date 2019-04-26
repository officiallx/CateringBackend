package org.obnoxious.controllers;

import org.obnoxious.Service.EventDateTimeService;
import org.obnoxious.entities.EventDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"http://localhost:4200" }, allowedHeaders="*")
public class EventDateTimeController {

    @Autowired
    private EventDateTimeService eventDateTimeService;

    @GetMapping("/datetime")
    public List<EventDateTime> getAllEventTimes(){
        return eventDateTimeService.getAllEvent();
    }

    @GetMapping("/datetime/{eventDatId}")
    public Optional<EventDateTime> getEventTime(@PathVariable Long eventDatId){
        return eventDateTimeService.getEvent(eventDatId);
    }

    @DeleteMapping("/datetime/{eventDatId}")
    public void deleteEventTime(@PathVariable Long eventDatId){
        eventDateTimeService.deleteEvent(eventDatId);
    }

    @PutMapping("/datetime/{eventDatId}")
    public void updateEventTime(@RequestBody EventDateTime datetime, @PathVariable Long eventDatId){
        eventDateTimeService.updateEvent(datetime);
    }

    @PostMapping("/datetime")
    public void addEventTime(@RequestBody EventDateTime datetime){
        eventDateTimeService.addEvent(datetime);
    }
}
