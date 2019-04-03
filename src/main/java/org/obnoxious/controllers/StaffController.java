package org.obnoxious.controllers;

import org.obnoxious.entities.Staff;
import org.obnoxious.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return (List<Staff>) staffRepository.findAll();
    }

    @GetMapping("/staff/{staffId}")
    public Staff getStaff(@PathVariable Long staffId) {
        return staffRepository.findOne(staffId);
    }

    @DeleteMapping("/staff/{staffId}")
    public boolean deleteStaff(@PathVariable Long staffId) {
        staffRepository.delete(staffId);
        return true;
    }

    @PutMapping("/staff")
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @PostMapping("/staff")
    public Staff createStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

}
