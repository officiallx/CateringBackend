package org.obnoxious.Service;

import org.obnoxious.entities.Tableware;
import org.obnoxious.repositories.TablewareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablewareService {

    @Autowired
    private TablewareRepository tablewareRepository;

    public List<Tableware> getAllUtensils(){
        return (List<Tableware>) tablewareRepository.findAll();
    }

    public Optional<Tableware> getUtensils(Long uId){
        return tablewareRepository.findById(uId);
    }

    public void addUtensils(Tableware tableware){
        tablewareRepository.save(tableware);
    }

    public void updateUtensils(Long uId, Tableware tableware) {
        tablewareRepository.save(tableware);
    }

    public void deleteUtensils(Long uId) {
        tablewareRepository.deleteById(uId);
    }
}
