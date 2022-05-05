package com.internet.jiaowuxitong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.internet.jiaowuxitong.entity.Teacher_course;
import com.internet.jiaowuxitong.mapper.TeachClassDao;
import com.internet.jiaowuxitong.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yh
 */
@Service
public class ClassServiceImpl extends ServiceImpl<TeachClassDao, Teacher_course> implements ClassService {

    @Autowired
    TeachClassDao teachClassDao;

    @Override
    public List<Teacher_course> getclass(String teacherid) {
        QueryWrapper<Teacher_course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",teacherid);
        return teachClassDao.selectList(queryWrapper);
    }
}
