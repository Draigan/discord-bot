package com.dre.Server.httpwebserver.services;

import com.dre.Server.httpwebserver.model.Photo;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhotoService {
    private Map<String, Photo> db = new HashMap<>() {
        {
            put("1", new Photo("1", "dixie.txt"));
            put("2", new Photo("2", "diddy.txt"));
        }
    };

    public Collection<Photo> get(){
        return db.values();
    }

    public Photo get(String id){
        return db.get(id);
    }

    public byte[] getData(String id){
        return db.get(id).getData();
    }



    public Photo save(byte[] data, String fileName, String contentType, String id){
        Photo photo = new Photo(id, fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        db.put(id, photo);
        System.out.println("From save");
        return photo;

    }
    public ResponseEntity<byte[]> download(String id) {
        System.out.println("Attempting download...");
        Photo photo = this.get(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data = this.getData(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("inline").filename(photo.getFileName()).build();
        headers.setContentDisposition(build);
        return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
    }


}
