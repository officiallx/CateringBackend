package org.obnoxious.Service;

import org.obnoxious.entities.Lunch;
import org.obnoxious.repositories.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LunchService {

    @Autowired
    private LunchRepository lunchRepository;

    public List<Lunch> getAllLunch(){
        List<Lunch> list = new ArrayList<>();
        lunchRepository.findAll()
                .forEach(list::add);
        return list;
    }

    public List<Lunch> getLunch(Long apackageId){
        return lunchRepository.findByPackageId(apackageId);
    }

    public void addLunch(Lunch lunch){
        lunchRepository.save(lunch);
    }

    public void updateLunch(Lunch lunch) {
        lunchRepository.save(lunch);
    }

    public void deleteLunch(Long lunchId) {
        lunchRepository.deleteById(lunchId);
    }
}
