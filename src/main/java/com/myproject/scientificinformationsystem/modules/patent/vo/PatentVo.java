package com.myproject.scientificinformationsystem.modules.patent.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatentVo {

    private Integer id;
    private String flag;
    private String projectName;
}
