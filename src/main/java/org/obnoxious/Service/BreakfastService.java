package org.obnoxious.Service;

import org.obnoxious.entities.Breakfast;
import org.obnoxious.repositories.BreakfastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BreakfastService {

    @Autowired
    private BreakfastRepository breakfastRepository;

    public List<Breakfast> getAllBreakfast(){
        List<Breakfast> list = new ArrayList<>();
        breakfastRepository.findAll()
                .forEach(list::add);
        return list;
    }

    public List<Breakfast> getBreakfast(Long apackageId){
        return breakfastRepository.findByPackageId(apackageId);
    }

    public void addBreakfast(Breakfast item){
        breakfastRepository.save(item);
    }

    public void updateBreakfast(Breakfast item) {
        breakfastRepository.save(item);
    }

    public void deleteBreakfast(Long breakfastId) {
        breakfastRepository.deleteById(breakfastId);
    }
}
