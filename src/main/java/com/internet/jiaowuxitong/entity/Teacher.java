package com.internet.jiaowuxitong.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "院id")
    private String collegeId;

    @ApiModelProperty(value = "教工号，10位")
    private String teacherId;

    @ApiModelProperty(value = "身份证号")
    private String identity;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "籍贯")
    private String nativeplace;

    @ApiModelProperty(value = "性别 0-男，1-女")
    private Boolean gender;

    @ApiModelProperty(value = "出生日期")
    private Date birth;

    @ApiModelProperty(value = "职称")
    private String title;

    @ApiModelProperty(value = "入职时间")
    private Date hiredate;

    @ApiModelProperty(value = "政治面貌 1-中共党员 2-共青团员 3-群众")
    private Integer political;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "照片")
    private String photo;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)

    /*
    yh
     */
    private Date gmtModified;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "判断密码是否使用")
    private Integer password_sign;


}
