package com.myproject.scientificinformationsystem.modules.project.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVo {

    private Integer id;
    private Integer userId;
    private Integer prizeId;
    private Integer paperId;
    private Integer patentId;
    private String name;
    private String levels;
    private String source;
    private String description;
    private String funds;
    private String startTime;
    private String endTime;
    private Integer passNum;
    private String status;
    private String resultPath;
    private String userName;
}
