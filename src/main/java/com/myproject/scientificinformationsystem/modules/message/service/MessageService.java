package com.myproject.scientificinformationsystem.modules.message.service;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.message.entity.Message;
import com.myproject.scientificinformationsystem.modules.message.vo.MessageVo;
import org.springframework.data.domain.Pageable;

public interface MessageService {

    boolean addMessage(Message message);

    PageInfo findPageByParams(Integer userId, Integer flag, MessageVo vo, Pageable pageable);
}
