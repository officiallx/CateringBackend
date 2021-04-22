package org.obnoxious.controllers;

import org.obnoxious.Service.LunchService;
import org.obnoxious.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
@RestController
@CrossOrigin(origins="https://cateringwebsite.herokuapp.com:443", allowedHeaders="*")
@RequestMapping("/api")
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