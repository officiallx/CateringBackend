package org.obnoxious.controllers;

import org.obnoxious.Service.StaffService;
import org.obnoxious.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/api")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/staff/{staffId}")
    public Optional<org.obnoxious.entities.Staff> getStaff(@PathVariable Long staffId) {
       return staffService.getStaff(staffId);
    }

    @DeleteMapping("/staff/{staffId}")
    public void deleteStaff(@PathVariable Long staffId) {
        staffService.deleteStaff(staffId);
    }

    @PutMapping("/staff/{staffId}")
    public void updateStaff(@RequestBody Staff staff, @PathVariable Long staffId) {
        staffService.updateStaff(staffId, staff);
    }

    @PostMapping("/staff")
    public void createStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
    }

}
