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

    @GetMapping("/eventtime")
    public List<EventDateTime> getAllEventTimes(){
        return eventDateTimeService.getAllEvent();
    }

    @GetMapping("/eventtime/{eventDatId}")
    public Optional<EventDateTime> getEventTime(@PathVariable Long eventDatId){
        return eventDateTimeService.getEvent(eventDatId);
    }

    @DeleteMapping("/eventtime/{eventDatId}")
    public void deleteEventTime(@PathVariable Long eventDatId){
        eventDateTimeService.deleteEvent(eventDatId);
    }

    @PutMapping("/eventtime/{eventId}")
    public void updateEventTime(@RequestBody EventDateTime eventtime, @PathVariable Long eventId){
        eventDateTimeService.updateEvent(eventtime);
    }

    @PostMapping("/eventtime")
    public void addEventTime(@RequestBody EventDateTime eventId){
        eventDateTimeService.addEvent(eventId);
    }
}
