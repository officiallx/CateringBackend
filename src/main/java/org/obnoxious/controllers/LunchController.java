package org.obnoxious.controllers;

import org.obnoxious.Service.LunchService;
import org.obnoxious.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class LunchController {

    @Autowired
    private LunchService lunchService;

    @GetMapping("/lunch")
    public List<Lunch> getAllLunch(){
        return lunchService.getAllLunch();
    }

    @GetMapping("/lunch/{packageId}")
    public List<Lunch> getLunch(@PathVariable("packageId") Long apackageId){
        return lunchService.getLunch(apackageId);
    }

    @DeleteMapping("/lunch/{packageId}")
    public void deleteLunch(@PathVariable Long packageId){
        lunchService.deleteLunch(packageId);
    }

    @PutMapping("/lunch/{packageId}")
    public void updateLunch(@RequestBody Lunch lunch, @PathVariable Long packageId, @PathVariable Long eventId){
        lunchService.updateLunch(lunch);
    }

    @PostMapping("/lunch")
    public void addLunch(@RequestBody Lunch lunch){
        lunchService.addLunch(lunch);
    }
}