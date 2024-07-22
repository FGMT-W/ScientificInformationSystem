package com.myproject.scientificinformationsystem.modules.thesis.controller;
import java.text.SimpleDateFormat;
import	java.util.UUID;
import	java.io.IOException;

import com.myproject.scientificinformationsystem.common.GemBeanUtils;
import com.myproject.scientificinformationsystem.common.PageInfo;
import com.myproject.scientificinformationsystem.common.SisResult;
import com.myproject.scientificinformationsystem.enums.ResultEnum;
import com.myproject.scientificinformationsystem.modules.thesis.entity.Thesis;
import com.myproject.scientificinformationsystem.modules.thesis.vo.ThesisAddVo;
import com.myproject.scientificinformationsystem.modules.thesis.vo.ThesisVo;
import com.myproject.scientificinformationsystem.modules.message.entity.Message;
import com.myproject.scientificinformationsystem.modules.message.service.MessageService;
import com.myproject.scientificinformationsystem.modules.thesispass.entity.Thesispass;
import com.myproject.scientificinformationsystem.modules.thesispass.service.ThesispassService;
import com.myproject.scientificinformationsystem.modules.thesis.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/thesis")
public class ThesisController {

    @Autowired
    ThesisService thesisService;

    @Autowired
    ThesispassService passService;

    @Autowired
    MessageService messageService;

    private static Integer adminNum = 3;

    @PostMapping("add")
    @ResponseBody
    public SisResult add(ThesisAddVo addVo){
        Thesis thesis = Thesis.translate(addVo);
        for(int i=1;i<=adminNum;i++){
            Message message = new Message(i, 1, "论文-"+addVo.getThesisname()+"已录入，请及时审核");
            messageService.addMessage(message);
        }
        return thesisService.addThesis(thesis) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public SisResult delete(Integer id){
        thesisService.deleteThesisById(id);
        return SisResult.ok();
    }

    @PostMapping("pass")
    @ResponseBody
    public SisResult pass(Integer thesisId, Integer adminId){
        if(passService.existsPassByThesisIdAndAdminId(thesisId,adminId)){
            return SisResult.build(404,"您已经审核过该论文了，请勿重复操作!");
        }
        Thesispass pass = new Thesispass(thesisId, adminId, "通过");
        passService.addPass(pass);
        Thesis target = thesisService.findThesisById(thesisId);
        Thesis thesis;
        if(passService.getPassCount(thesisId)==1){
            thesis = new Thesis(thesisId, target.getPassNum()+1, "审核通过");
        }else{
            thesis = new Thesis(thesisId, target.getPassNum()+1);
        }
        GemBeanUtils.copyProperties(thesis,target);
        return thesisService.updateThesis(target) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @PostMapping("no-pass")
    @ResponseBody
    public SisResult noPass(Integer thesisId, Integer adminId){
        if(passService.existsPassByThesisIdAndAdminId(thesisId,adminId)){
            return SisResult.build(404,"您已经审核过该论文了，请勿重复操作!");
        }
        Thesispass pass = new Thesispass(thesisId, adminId, "不通过");
        passService.addPass(pass);
        Thesis target = thesisService.findThesisById(thesisId);
        Thesis thesis = new Thesis(thesisId, target.getPassNum()+2, "审核不通过");
        GemBeanUtils.copyProperties(thesis,target);
        return thesisService.updateThesis(target) == true ? SisResult.ok() : SisResult.build(ResultEnum.FAIL);
    }

    @PostMapping("submit")
    @ResponseBody
    public SisResult submit(@RequestParam("file") MultipartFile file,  String dict) throws IOException {
        if(!file.isEmpty()){
            Map<String,String> data = new HashMap<>();
            String fileName = file.getOriginalFilename();
            File directory = new File("src/main/resources/");
            String path = directory.getCanonicalPath()+"/templates/"+dict;
            /*File directory = new File("E:/JavaProject/source/");
            String path = directory.getCanonicalPath()+"/"+dict;*/
            String name = UUID.randomUUID().toString();
            String ext = file.getOriginalFilename().substring(
                    file.getOriginalFilename().lastIndexOf("."));
            data.put("name",fileName);
            data.put("path",dict+name+ext);
            try{
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(path, name+ext)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            }catch (IOException e){
                e.printStackTrace();
                return SisResult.build(ResultEnum.FAIL);
            }
            return SisResult.build(200,"上传成功！",data);
        }else{
            return SisResult.build(ResultEnum.FAIL);
        }
    }

    @GetMapping("queryAll")
    @ResponseBody
    public SisResult queryAll(){
        return SisResult.ok(thesisService.findAll());
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public SisResult pageByParams(ThesisVo vo, Pageable pageable){
        PageInfo pageInfo = thesisService.findPageByParams(vo, pageable);
        return SisResult.getTable(pageInfo);
    }

    @GetMapping("pageThesisByParams")
    @ResponseBody
    public SisResult pageThesisByParams(ThesisVo vo, Pageable pageable){
        PageInfo pageInfo = thesisService.findThesisPageByParams(vo, pageable);
        return SisResult.getTable(pageInfo);
    }

}
