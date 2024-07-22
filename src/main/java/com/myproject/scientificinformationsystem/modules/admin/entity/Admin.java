package com.myproject.scientificinformationsystem.modules.admin.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sysadmin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String account;
    private String password;
    private String name;

    public Admin(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

