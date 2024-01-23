package com.dre.Server.httpwebserver.model;

import jdk.jfr.ContentType;

public class Photo {
    private String id;
    private byte[] data;
    private String fileName;

    private String contentType;
    public Photo(String id, String fileName){
       this.id = id;
       this.fileName = fileName;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
