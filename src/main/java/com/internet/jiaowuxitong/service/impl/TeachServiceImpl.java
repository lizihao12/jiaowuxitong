package com.internet.jiaowuxitong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.internet.jiaowuxitong.entity.Teacher;
import com.internet.jiaowuxitong.mapper.TeacherDao;
import com.internet.jiaowuxitong.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * yh
 */
@Service
public class TeachServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeachService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public Teacher getTeacher(String teacher_id, String password) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",teacher_id);
        queryWrapper.eq("password",password);
        return teacherDao.selectOne(queryWrapper);
    }

    @Override
    public Boolean uppassword(String teacher_id,String password) {
        UpdateWrapper<Teacher> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("teacher_id",teacher_id);
        updateWrapper.set("password",password);
        return teacherDao.update(null,updateWrapper)==1 ;
    }
}
