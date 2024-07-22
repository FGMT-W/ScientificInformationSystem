package com.myproject.scientificinformationsystem.modules.message.dao;

import com.myproject.scientificinformationsystem.modules.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageDao extends JpaRepository<Message, Integer>, JpaSpecificationExecutor<Message> {

}
