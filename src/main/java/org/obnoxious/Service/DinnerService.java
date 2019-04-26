package org.obnoxious.Service;

import org.obnoxious.entities.Dinner;
import org.obnoxious.repositories.DinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DinnerService {

    @Autowired
    private DinnerRepository dinnerRepository;

    public List<Dinner> getAllDinner(){
        List<Dinner> list = new ArrayList<>();
        dinnerRepository.findAll()
                .forEach(list::add);
        return list;
    }

    public List<Dinner> getDinner(Long apackageId){
        return dinnerRepository.findByPackageId(apackageId);
    }

    public void addDinner(Dinner dinner){
        dinnerRepository.save(dinner);
    }

    public void updateDinner(Dinner dinner) {
        dinnerRepository.save(dinner);
    }

    public void deleteDinner(Long dinnerId) {
        dinnerRepository.deleteById(dinnerId);
    }
}
