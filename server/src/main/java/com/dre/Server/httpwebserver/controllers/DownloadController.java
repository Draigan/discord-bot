package com.dre.Server.httpwebserver.controllers;

import com.dre.Server.httpwebserver.services.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class DownloadController {

    PhotoService photoService;

    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @GetMapping("/download")
    public String greet(){
        return "Hey from downloads";
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        return photoService.download(id);
    }

}
