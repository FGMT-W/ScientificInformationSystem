package com.myproject.scientificinformationsystem.modules.project.entity;

import com.myproject.scientificinformationsystem.modules.project.vo.ProjectAddVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private Integer userId;
    private String name;
    private String levels;
    private String source;
    private String description;
    private String funds;
    private String startTime;
    private String endTime;
    private Integer passNum;
    private String status;
    private String resultPath;

    public static Project translate(ProjectAddVo addVo){
        return new Project(addVo.getName(),addVo.getLevels(),addVo.getSource(),addVo.getDescription(),addVo.getFunds(),addVo.getUserId());
    }

    public Project(String name, String levels, String source, String description, String funds, Integer userId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.name = name;
        this.levels = levels;
        this.source = source;
        this.description = description;
        this.funds = funds;
        this.startTime = df.format(System.currentTimeMillis());
        this.status = "待授权";
        this.passNum = 0;
        this.userId = userId;
    }

    public Project(Integer id, Integer passNum){
        this.id = id;
        this.passNum = passNum;
    }

    public Project(Integer id, Integer passNum, String status){
        this.id = id;
        this.passNum = passNum;
        this.status = status;
    }

    public Project(Integer id, String status){
        this.id = id;
        this.status = status;
    }

    public Project(Integer id, String status, String endTime){
        this.id = id;
        this.status = status;
        this.endTime = endTime;
    }

    public Project(Integer userId) {
        this.userId = userId;
    }

    public Project() {
    }
}

