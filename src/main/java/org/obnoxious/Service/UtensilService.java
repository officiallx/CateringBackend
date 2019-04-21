package org.obnoxious.Service;

import org.obnoxious.entities.Utensil;
import org.obnoxious.repositories.UtensilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtensilService {

    @Autowired
    private UtensilRepository utensilRepository;

    public List<Utensil> getAllUtensils(){
        return (List<Utensil>) utensilRepository.findAll();
    }

    public Optional<Utensil> getUtensils(Long uId){
        return utensilRepository.findById(uId);
    }

    public void addUtensils(Utensil utensil){
        utensilRepository.save(utensil);
    }

    public void updateUtensils(Long uId, Utensil utensil) {
        utensilRepository.save(utensil);
    }

    public void deleteUtensils(Long uId) {
        utensilRepository.deleteById(uId);
    }
}
