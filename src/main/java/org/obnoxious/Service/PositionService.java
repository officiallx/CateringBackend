package org.obnoxious.Service;

import org.obnoxious.entities.Position;
import org.obnoxious.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPosition(){
        return (List<Position>) positionRepository.findAll();
    }

    public Optional<Position> getPosition(Long positionId){
        return positionRepository.findById(positionId);
    }

    public void addPosition(Position position){
        positionRepository.save(position);
    }

    public void updatePosition(Position position) {
        positionRepository.save(position);
    }

    public void deletePosition(Long positionId) {
        positionRepository.deleteById(positionId);
    }
}
