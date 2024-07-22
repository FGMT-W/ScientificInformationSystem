package com.myproject.scientificinformationsystem.modules.user.dao;

import com.myproject.scientificinformationsystem.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {

    List<User> findByName(String name);

    void deleteById(Integer id);

    Optional<User> findById(Integer id);

    User findByAccount(String account);

    User findByAccountAndPassword(String account,String password);

    boolean existsUserByAccount(String account);
}

