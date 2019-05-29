package org.obnoxious.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.obnoxious.Service.FileStorageService;
import org.obnoxious.Service.PackageService;
import org.obnoxious.entities.*;
import org.obnoxious.entities.Package;
import org.obnoxious.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class PackageController {

    @Autowired
    private PackageService packageService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/event/getAll")
    public Iterable<Package> getAll(){
        return packageService.getAll();
    }


    @GetMapping("/event/{eventId}/packages")
    public List<Package> getAllPackages(@PathVariable Long eventId){
        return packageService.getAllPackages(eventId);
    }

    @GetMapping("/event/{eventId}/package/{packageId}")
    public Optional<Package> getItem(@PathVariable Long packageId){
        return packageService.getPackage(packageId);
    }

    @DeleteMapping("/event/{eventId}/package/{packageId}")
    public void deleteItem(@PathVariable Long packageId){
        packageService.deletePackage(packageId);
    }

    @PutMapping("/event/{eventId}/package/{packageId}")
    public void updateItem(@RequestBody Package item, @PathVariable Long packageId, @PathVariable Long eventId){
        item.setEvent(new Event(eventId,"",""));
        packageService.updatePackage(item);
    }

//    @PostMapping("/event/{eventId}/package")
//    public void addItem(@RequestBody Package item,@PathVariable Long eventId){
//        item.setEvent(new Event(eventId,"",""));
//        packageService.addPackage(item);
//    }

    @PostMapping( value = "/event/{eventId}/package", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createEvent(@PathVariable Long eventId,
            @RequestParam(value = AppConstants.PACKAGE_JSON_PARAM, required = true) String eventJson,
            @RequestParam(required = true, value = AppConstants.EVENT_FILE_PARAM) MultipartFile file)
            throws IOException {

        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromPath("http://192.168.100.24:8080").path(AppConstants.DOWNLOAD_PATH)
                .path(fileName).toUriString();
        Package aPackage = objectMapper.readValue(eventJson, Package.class);
        aPackage.setProfilePath(fileDownloadUri);
        aPackage.setEvent(new Event(eventId,"",""));
        packageService.addPackage(aPackage);

        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.PKG_SUCCESS_MSG);
    }
}