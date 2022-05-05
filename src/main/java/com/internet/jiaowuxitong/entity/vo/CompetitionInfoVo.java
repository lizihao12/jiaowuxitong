package com.internet.jiaowuxitong.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompetitionInfoVo {
    @ApiModelProperty(value = "课程名")
    private String img;

    @ApiModelProperty(value = "类别")
    private String category;

//    @ApiModelProperty(value = "名称")
//    private String name;

    @ApiModelProperty(value = "内容")
    private String content;
}
