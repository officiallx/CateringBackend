package org.obnoxious.controllers;

import org.obnoxious.Service.UtensilService;
import org.obnoxious.entities.Utensil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UtensilController {

    @Autowired
    private UtensilService utensilService;

    @GetMapping("/utensils")
    public List<Utensil> getAllUtensils(){
        return utensilService.getAllUtensils();
    }

    @GetMapping("/utensil/{uId}")
    public Optional<Utensil> getUtensils(@PathVariable Long uId){
        return utensilService.getUtensils(uId);
    }

    @DeleteMapping("/utensil/{uId}")
    public void deleteUtensils(@PathVariable Long uId){
        utensilService.deleteUtensils(uId);
    }

    @PutMapping("/utensil/{uId}")
    public void updateUtensils(@RequestBody Utensil utensil, @PathVariable Long uId){
        utensilService.updateUtensils(uId, utensil);
    }

    @PostMapping("/utensil")
    public void addUtensils(@RequestBody Utensil utensils){
        utensilService.addUtensils(utensils);
    }
}