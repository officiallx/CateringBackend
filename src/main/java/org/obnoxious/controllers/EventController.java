package org.obnoxious.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.obnoxious.Service.EventService;
import org.obnoxious.Service.FileStorageService;
import org.obnoxious.entities.AppResponse;
import org.obnoxious.entities.Event;
import org.obnoxious.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins= {"*" }, allowedHeaders="*")
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    @GetMapping("/event/{eventId}")
    public Optional<Event> getEvent(@PathVariable Long eventId){
        return eventService.getEvent(eventId);
    }

    @DeleteMapping("/event/{eventId}")
    public void deleteEvent(@PathVariable Long eventId){
        eventService.deleteEvent(eventId);
    }

    @PutMapping("/event/{eventId}")
    public void updateEvent(@RequestBody Event event, @PathVariable Long eventId){
        eventService.updateEvent(event);
    }

    @PostMapping( value = "/event", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createEvent(
            @RequestParam(value = AppConstants.EVENT_JSON_PARAM, required = true) String eventJson,
            @RequestParam(required = true, value = AppConstants.EVENT_FILE_PARAM) MultipartFile file)
            throws IOException {

        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromPath("https://drive.google.com/drive/u/1/folders/1J3DrVw3FNjinK_45rtoaUO5uw-Po2EFF").path(AppConstants.DOWNLOAD_PATH)
                .path(fileName).toUriString();
        Event event = objectMapper.readValue(eventJson, Event.class);
        event.setProfilePath(fileDownloadUri);
        eventService.addEvent(event);

        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
    }
}
