package com.internet.jiaowuxitong.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentsInfoVo {

    @ApiModelProperty(value = "学号")
    private String studentId;
    @ApiModelProperty(value = "学生姓名")
    private String name;
    @ApiModelProperty(value = "专业")
    private String major;
    @ApiModelProperty(value = "年纪")
    private Integer garde;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "班级")
    private String classes;











}
