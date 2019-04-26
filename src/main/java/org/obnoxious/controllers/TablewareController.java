package org.obnoxious.controllers;

import org.obnoxious.Service.TablewareService;
import org.obnoxious.entities.Tableware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class TablewareController {

    @Autowired
    private TablewareService tablewareService;

    @GetMapping("/utensils")
    public List<Tableware> getAllUtensils(){
        return tablewareService.getAllUtensils();
    }

    @GetMapping("/utensil/{uId}")
    public Optional<Tableware> getUtensils(@PathVariable Long uId){
        return tablewareService.getUtensils(uId);
    }

    @DeleteMapping("/utensil/{uId}")
    public void deleteUtensils(@PathVariable Long uId){
        tablewareService.deleteUtensils(uId);
    }

    @PutMapping("/utensil/{uId}")
    public void updateUtensils(@RequestBody Tableware tableware, @PathVariable Long uId){
        tablewareService.updateUtensils(uId, tableware);
    }

    @PostMapping("/utensil")
    public void addUtensils(@RequestBody Tableware utensils){
        tablewareService.addUtensils(utensils);
    }
}