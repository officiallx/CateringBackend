package org.obnoxious.controllers;


import org.obnoxious.Service.AddressService;
import org.obnoxious.Service.PositionService;
import org.obnoxious.entities.Address;
import org.obnoxious.entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="https://cateringwebsite.herokuapp.com:443", allowedHeaders="*")
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/position")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("/position/{positionId}")
    public Optional<Position> getPosition(@PathVariable("positionId") Long positionId){
        return positionService.getPosition(positionId);
    }

    @DeleteMapping("/position/{positionId}")
    public void deletePosition(@PathVariable Long positionId){
        positionService.deletePosition(positionId);
    }

    @PutMapping("/position/{positionId}")
    public void updatePosition(@RequestBody Position position, @PathVariable Long positionId){
        positionService.updatePosition(position);
    }

    @PostMapping("/position")
    public void addPosition(@RequestBody Position position){
        positionService.addPosition(position);
    }
}

