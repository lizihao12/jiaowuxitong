package com.internet.jiaowuxitong.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 学生信息
 */
@Data
public class StudentInfoVo {
    @ApiModelProperty(value = "昵称")
    private String name;

    @ApiModelProperty(value = "注册邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "兴趣")
    private String interset;

    @ApiModelProperty(value = "介绍内容")
    private String indroduction;

}
