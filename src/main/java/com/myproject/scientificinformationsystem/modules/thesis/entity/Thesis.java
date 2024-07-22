package com.myproject.scientificinformationsystem.modules.thesis.entity;

import com.myproject.scientificinformationsystem.modules.thesis.vo.ThesisAddVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;


@Entity
@Data
@AllArgsConstructor
@Table(name = "Thesis")
public class Thesis {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String author;
    private String thesisname;
    private String type;
    private String startTime;
    private String publication;
    private String thesisabstract;
    private String status;
    private Integer passNum;
    private String thesisPath;

    public static Thesis translate(ThesisAddVo addVo){
        return new Thesis(addVo.getAuthor(),addVo.getThesisname(),addVo.getType(),addVo.getStartTime(),addVo.getPublication(),addVo.getThesisabstract(),addVo.getThesisPath());
    }

    public Thesis(String author, String thesisname, String type, String startTime, String publication, String thesisabstract, String thesisPath) {
        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
        /*this.startTime = df.format(System.currentTimeMillis());*/
        this.author = author;
        this.thesisname = thesisname;
        this.type = type;
        this.publication = publication;
        this.thesisabstract = thesisabstract;
        this.startTime = startTime;
        this.status = "待审核";
        this.passNum = 0;
        this.thesisPath = thesisPath;
    }

    public Thesis(Integer id, Integer passNum){
        this.id = id;
        this.passNum = passNum;
    }

    public Thesis(Integer id, Integer passNum, String status){
        this.id = id;
        this.passNum = passNum;
        this.status = status;
    }

    public Thesis(Integer id, String status){
        this.id = id;
        this.status = status;
    }

    public Thesis() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPassNum() {
        return passNum;
    }

    public void setPassNum(Integer passNum) {
        this.passNum = passNum;
    }

    public String getThesisPath() {
        return thesisPath;
    }

    public void setThesisPath(String thesisPath) {
        this.thesisPath = thesisPath;
    }
}

