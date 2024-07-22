package com.myproject.scientificinformationsystem.modules.paper.controller;

import com.myproject.scientificinformationsystem.common.GemBeanUtils;
import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.common.SisResult;
import com.myproject.scientificinformationsystem.enums.ResultEnum;
import com.myproject.scientificinformationsystem.modules.message.entity.Message;
import com.myproject.scientificinformationsystem.modules.message.service.MessageService;
import com.myproject.scientificinformationsystem.modules.paper.entity.Paper;
import com.myproject.scientificinformationsystem.modules.paper.vo.PaperVo;
import com.myproject.scientificinformationsystem.modules.project.entity.Project;
import com.myproject.scientificinformationsystem.modules.project.service.ProjectService;
import com.myproject.scientificinformationsystem.modules.paper.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @Autowired
    ProjectService projectService;

    @Autowired
    MessageService messageService;

    private static Integer adminNum = 3;

    @PostMapping("add")
    @ResponseBody
    public SisResult add(Integer projectId, String path){
        Paper old = paperService.findPaperByProjectId(projectId);
        if(old != null){
            return SisResult.build(404,"您已上传过该项目的说明书，请勿重复操作!");
        }
        Project project = projectService.findProjectById(projectId);
        for(int i=1;i<=adminNum;i++){
            Message message = new Message(i, 1, "项目-"+project.getName()+"已上传说明书，请及时查阅");
            messageService.addMessage(message);
        }
        Paper paper = new Paper(projectId, path);
        return paperService.addPaper(paper) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public SisResult delete(Integer id){
        paperService.deletePaperById(id);
        return SisResult.ok();
    }

    @PostMapping("update")
    @ResponseBody
    public SisResult update(Integer projectId, String path){
        Project project = projectService.findProjectById(projectId);
        for(int i=1;i<=adminNum;i++){
            Message message = new Message(i, 1, "项目-"+project.getName()+"已修正说明书，请及时查阅");
            messageService.addMessage(message);
        }
        Paper target = paperService.findPaperByProjectId(projectId);
        Paper paper = new Paper(projectId, path);
        GemBeanUtils.copyProperties(paper,target);
        return paperService.updatePaper(target) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public SisResult pageByParams(PaperVo vo, Pageable pageable){
        PageInfo pageInfo = paperService.findPageByParams(vo, pageable);
        return SisResult.getTable(pageInfo);
    }

    @GetMapping("pageByUserParams")
    @ResponseBody
    public SisResult pageUserAndProjectByParams(Integer userId, Pageable pageable){
        PageInfo pageInfo = paperService.findPageByUserParams(userId, pageable);
        return SisResult.getTable(pageInfo);
    }
}
