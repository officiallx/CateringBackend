package org.obnoxious.controllers;

import org.obnoxious.Service.BreakfastService;
import org.obnoxious.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class BreakfastController {

    @Autowired
    private BreakfastService breakfastService;

    @GetMapping("/breakfasts")
    public List<Breakfast> getAllBreakfast(){
        return breakfastService.getAllBreakfast();
    }

    @GetMapping("/breakfast/{packageId}")
    public List<Breakfast> getBreakfast(@PathVariable("packageId") Long apackageId){
        return breakfastService.getBreakfast(apackageId);
    }

    @GetMapping("/breakfast/delete/{packageId}")
    public void deleteItem(@PathVariable Long packageId){
        System.out.println(packageId);
        breakfastService.deleteBreakfast(packageId);
    }

    @PutMapping("/breakfast/{packageId}")
    public void updateItem(@RequestBody Breakfast breakfast, @PathVariable Long packageId, @PathVariable Long eventId){
        breakfastService.updateBreakfast(breakfast);
    }

    @PostMapping("/breakfast")
    public void addItem(@RequestBody Breakfast breakfast){
        breakfastService.addBreakfast(breakfast);
    }
}