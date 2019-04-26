package org.obnoxious.controllers;

import org.obnoxious.Service.DinnerService;
import org.obnoxious.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class DinnerController {

    @Autowired
    private DinnerService dinnerService;

    @GetMapping("/dinner")
    public List<Dinner> getAllDinner(){
        return dinnerService.getAllDinner();
    }

    @GetMapping("/dinner/{packageId}")
    public List<Dinner> getDinner(@PathVariable("packageId") Long apackageId){
        return dinnerService.getDinner(apackageId);
    }

    @DeleteMapping("/dinner/{packageId}")
    public void deleteDinner(@PathVariable Long packageId){
        dinnerService.deleteDinner(packageId);
    }

    @PutMapping("/dinner/{packageId}")
    public void updateDinner(@RequestBody Dinner dinner, @PathVariable Long packageId){
        dinnerService.updateDinner(dinner);
    }

    @PostMapping("/dinner")
    public void addDinner(@RequestBody Dinner dinner){
        dinnerService.addDinner(dinner);
    }
}