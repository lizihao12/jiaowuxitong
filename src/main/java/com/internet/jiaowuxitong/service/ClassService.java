package com.internet.jiaowuxitong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.internet.jiaowuxitong.entity.Teacher_course;

import java.util.List;

/**
 * yh
 */
public interface ClassService extends IService<Teacher_course> {
    List<Teacher_course> getclass(String teacherid);
}
