package com.myproject.scientificinformationsystem.modules.patent.controller;

import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.common.SisResult;
import com.myproject.scientificinformationsystem.enums.ResultEnum;
import com.myproject.scientificinformationsystem.modules.message.entity.Message;
import com.myproject.scientificinformationsystem.modules.message.service.MessageService;
import com.myproject.scientificinformationsystem.modules.patent.entity.Patent;
import com.myproject.scientificinformationsystem.modules.patent.service.PatentService;
import com.myproject.scientificinformationsystem.modules.patent.vo.PatentVo;
import com.myproject.scientificinformationsystem.modules.project.entity.Project;
import com.myproject.scientificinformationsystem.modules.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    PatentService patentService;

    @Autowired
    ProjectService projectService;

    @Autowired
    MessageService messageService;

    @PostMapping("add")
    @ResponseBody
    public SisResult add(Integer projectId){
        Patent old = patentService.findPatentByProjectId(projectId);
        if(old != null){
            return SisResult.build(404,"该项目已有专利，请勿重复操作!");
        }
        String flag = UUID.randomUUID().toString().substring(0,6);
        Project project = projectService.findProjectById(projectId);
        Message message = new Message(project.getUserId(), 0, "您的项目-"+project.getName()+"获得专利——"+flag);
        messageService.addMessage(message);
        Patent patent = new Patent(projectId, flag);
        return patentService.addPatent(patent) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public SisResult delete(Integer id){
        patentService.deletePatentById(id);
        return SisResult.ok();
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public SisResult pageByParams(PatentVo vo, Pageable pageable){
        PageInfo pageInfo = patentService.findPageByParams(vo, pageable);
        return SisResult.getTable(pageInfo);
    }

    @GetMapping("pageByUserParams")
    @ResponseBody
    public SisResult pageUserAndProjectByParams(Integer userId, Pageable pageable){
        PageInfo pageInfo = patentService.findPageByUserParams(userId, pageable);
        return SisResult.getTable(pageInfo);
    }
}
