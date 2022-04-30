package com.internet.jiaowuxitong.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "密码标记")
    private Integer passwordSign;

    @ApiModelProperty(value = "描述内容")
    private String content;

    @ApiModelProperty(value = "业余爱好")
    private String hobby;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "学号")
    private String studentId;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String identity;

    @ApiModelProperty(value = "入学日期")
    private Date hiredate;

    @ApiModelProperty(value = "性别 0-男，1-女")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Date birth;

    @ApiModelProperty(value = "籍贯")
    private String nativeplace;

    @ApiModelProperty(value = "政治面貌 1-中共党员  2-共青团员 3-群众")
    private Integer political;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "照片")
    private String photo;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
