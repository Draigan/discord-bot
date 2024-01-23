package com.dre.Server.httpwebserver.controllers;

import com.dre.Server.httpwebserver.model.Photo;
import com.dre.Server.httpwebserver.services.PhotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController
public class PhotosController {

    // Dependency injection - Spring automatically injects a photoservice singleton in here
    PhotoService photoService;

    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photos")
    public Collection<Photo> getAllPhotos() {
        return photoService.get();
    }

    @GetMapping("/test")
    public String test(@RequestParam(name = "cool", defaultValue = "defaultvalue") String paramName){
       return "hello" + paramName;
    }
    @GetMapping("/photos/{id}")
    public Photo getPhotoById(@PathVariable String id) {
      return photoService.get(id);
    }

    //Request Photos using @RequestParam example
    @GetMapping("/photostest{id}")
    public Photo getPhotoByIdParam(@RequestParam(name = "id",  required = false) String id) {
        return photoService.get(id);
    }

    @GetMapping("/")
    public String greeting() {
        return "Hello Draigan!!!";
    }

    // Recieve a file and respond with the url
    @PostMapping("/upload")
    public ResponseEntity<String> uploadWithResponse(@RequestPart("data") MultipartFile file) throws IOException {
        String id = UUID.randomUUID().toString();
        photoService.save(file.getBytes(), file.getOriginalFilename(), file.getContentType(), id);
        return ResponseEntity.ok().body("{\"fileUrl\": \"" + "http://localhost:8080/download/" + id + "\"}");
    }
}

