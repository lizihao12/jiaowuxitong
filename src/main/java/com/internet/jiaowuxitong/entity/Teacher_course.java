package com.internet.jiaowuxitong.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/***
 * yh
 */
@Data
@ToString
@TableName("Teacher_course")
public class Teacher_course {
    @TableId("teacher_id")
    private String teacher_id;
    private String class_id;
    private String description;
}
