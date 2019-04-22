package org.obnoxious.Service;

import org.obnoxious.entities.Package;
import org.obnoxious.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<Package> getAllPackages(Long packageId){
        return packageRepository.findByEvent_EventId(packageId);
    }

    public Optional<Package> getPackage(Long packageId){
        return packageRepository.findById(packageId);
    }

    public void addPackage(Package item){
        packageRepository.save(item);
    }

    public void updatePackage(Package item) {
        packageRepository.save(item);
    }

    public void deletePackage(Long packageId) {
        packageRepository.deleteById(packageId);
    }
}
