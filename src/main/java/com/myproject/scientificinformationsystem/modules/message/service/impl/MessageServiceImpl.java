package com.myproject.scientificinformationsystem.modules.message.service.impl;

import com.myproject.scientificinformationsystem.common.GemBeanUtils;
import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.modules.message.service.MessageService;
import com.myproject.scientificinformationsystem.modules.message.dao.MessageDao;
import com.myproject.scientificinformationsystem.modules.message.entity.Message;
import com.myproject.scientificinformationsystem.modules.message.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public boolean addMessage(Message message) {
        Message save = messageDao.save(message);
        return save != null ? true : false;
    }

    @Override
    public PageInfo findPageByParams(Integer userId, Integer flag, MessageVo vo, Pageable pageable) {
        Message entity = new Message(flag, userId);
        GemBeanUtils.copyProperties(vo, entity);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写
        Page<Message> page = messageDao.findAll(Example.of(entity,matcher),pageable);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
    }
}
