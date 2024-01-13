package com.dre.webserver;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;
@CrossOrigin(origins ="*")
@RestController
public class PhotozController {
    private Map<String, Photo> db = new HashMap<>(){
        {
            put("1", new Photo("1", "diddy.txt"));
            put("2", new Photo("2", "dixie.txt"));
        }
    };

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return db.values();
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        System.out.println("Trying to delete...." + id);
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @GetMapping("/draigan")
    public String draigan() {
        return "Hello Draigan";
    }


    @PostMapping("/photoz")
    public Photo create(@RequestBody  @Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }

    @PostMapping("/upload")
    public Photo getPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;

    }
}
