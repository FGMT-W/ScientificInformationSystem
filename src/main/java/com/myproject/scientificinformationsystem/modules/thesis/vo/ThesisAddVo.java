package com.myproject.scientificinformationsystem.modules.thesis.vo;

import lombok.Data;

@Data
public class ThesisAddVo {

    private String author;
    private String thesisname;
    private String type;
    private String startTime;
    private String publication;
    private String thesisabstract;
    private String thesisPath;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThesisname() {
        return thesisname;
    }

    public void setThesisname(String thesisname) {
        this.thesisname = thesisname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getThesisabstract() {
        return thesisabstract;
    }

    public void setThesisabstract(String thesisabstract) {
        this.thesisabstract = thesisabstract;
    }

    public String getThesisPath() {
        return thesisPath;
    }

    public void setThesisPath(String thesisPath) {
        this.thesisPath = thesisPath;
    }
}
