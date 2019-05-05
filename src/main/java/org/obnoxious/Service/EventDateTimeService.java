package org.obnoxious.Service;

import org.obnoxious.entities.EventDateTime;
import org.obnoxious.repositories.EventDateTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventDateTimeService {

    @Autowired
    private EventDateTimeRepository eventDateTimeRepository;

    public List<EventDateTime> getAllEvent(){
        return (List<EventDateTime>) eventDateTimeRepository.findAll();
    }

    public Optional<EventDateTime> getEvent(Long eventDatId){
        return eventDateTimeRepository.findById(eventDatId);
    }

    public EventDateTime addEvent(EventDateTime event){
        return eventDateTimeRepository.save(event);
    }

    public void updateEvent(EventDateTime event) {
        eventDateTimeRepository.save(event);
    }

    public void deleteEvent(Long eventDatId) {
        eventDateTimeRepository.deleteById(eventDatId);
    }
}
