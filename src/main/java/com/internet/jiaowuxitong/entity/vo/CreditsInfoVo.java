package com.internet.jiaowuxitong.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 成绩
 */
@Data
public class CreditsInfoVo {
    @ApiModelProperty(value = "课程名")
    private String courseName;





    @ApiModelProperty(value = "课程学分")
    private Integer credit;
}
