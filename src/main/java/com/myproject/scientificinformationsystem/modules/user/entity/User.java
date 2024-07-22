package com.myproject.scientificinformationsystem.modules.user.entity;

import com.myproject.scientificinformationsystem.modules.user.vo.AddVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String account;
    private String password;
    private String name;

    public static User translate(AddVo addVo){
        return new User(addVo.getAccount(),addVo.getPassword(),addVo.getName());
    }

    public User(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public User() {
    }
}
