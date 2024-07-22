package com.myproject.scientificinformationsystem.modules.thesisstatisty.controller;

import com.myproject.scientificinformationsystem.common.SisResult;
import com.myproject.scientificinformationsystem.modules.thesisstatisty.service.ThesisstatistyService;
import com.myproject.scientificinformationsystem.modules.thesisstatisty.vo.EchartsForThesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
@RequestMapping("/thesisstatisty")
public class ThesisstatistyController {

    @Autowired
    ThesisstatistyService thesisstatistyService;

    @GetMapping("getEchartsPie")
    @ResponseBody
    public SisResult getEchartsPie(){
        ArrayList<EchartsForThesis> list = new ArrayList<EchartsForThesis>();
        EchartsForThesis echarts = new EchartsForThesis("EI",thesisstatistyService.getProjectOne());
        list.add(echarts);
        echarts = new EchartsForThesis("SCI",thesisstatistyService.getProjectTwo());
        list.add(echarts);
        echarts = new EchartsForThesis("TPSI",thesisstatistyService.getProjectThree());
        list.add(echarts);
        echarts = new EchartsForThesis("SCIE",thesisstatistyService.getProjectFour());
        list.add(echarts);
        echarts = new EchartsForThesis("核心",thesisstatistyService.getProjectFive());
        list.add(echarts);
        return SisResult.build(200,"",list);
    }
}
