package com.myproject.scientificinformationsystem.modules.user.service;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.user.vo.UpdateVo;
import com.myproject.scientificinformationsystem.modules.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {

    boolean addUser(User user);

    boolean deleteUserById(Integer id);

    boolean updateUser(User user);

    List<User> findUserByName(String name);

    User findUserById(Integer id);

    List<User> findAll();

    User findByAccount(String account);

    boolean isExist(String account,String password);

    PageInfo findPageByParams(UpdateVo vo, Pageable pageable);

}
