package org.obnoxious.Service;

import org.obnoxious.entities.Event;
import org.obnoxious.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvent(){
        return (List<Event>) eventRepository.findAll();
    }

    public Optional<Event> getEvent(Long eventId){
        return eventRepository.findById(eventId);
    }

    public void addEvent(Event event){
        eventRepository.save(event);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
