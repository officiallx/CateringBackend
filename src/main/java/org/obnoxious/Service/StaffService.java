package org.obnoxious.Service;

import org.obnoxious.entities.Staff;
import org.obnoxious.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff(){
        return (List<Staff>) staffRepository.findAll();
    }

    public Optional<Staff> getStaff(Long staffId){
        return staffRepository.findById(staffId);
    }

    public void addStaff(Staff staff){
        staffRepository.save(staff);
    }

    public void updateStaff(Long staffId, Staff staff) {
        staffRepository.save(staff);
    }

    public void deleteStaff(Long staffId) {
        staffRepository.deleteById(staffId);
    }
}