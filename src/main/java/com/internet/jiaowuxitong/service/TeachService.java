package com.internet.jiaowuxitong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.internet.jiaowuxitong.entity.Teacher;

/**
 * yh
 */
public interface TeachService extends IService<Teacher> {
    Teacher getTeacher(String teacher_id, String password);
    Boolean uppassword(String teacher_id, String password);
}
