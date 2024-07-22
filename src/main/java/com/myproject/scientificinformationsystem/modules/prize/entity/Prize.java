package com.myproject.scientificinformationsystem.modules.prize.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Prize")
public class Prize {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private Integer projectId;
    private String name;

    public Prize(Integer projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }
}
