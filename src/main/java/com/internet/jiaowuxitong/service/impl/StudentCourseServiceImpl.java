package com.internet.jiaowuxitong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.internet.jiaowuxitong.entity.Course;
import com.internet.jiaowuxitong.entity.StudentCourse;
import com.internet.jiaowuxitong.entity.vo.CreditsInfoVo;
import com.internet.jiaowuxitong.mapper.StudentCourseMapper;
import com.internet.jiaowuxitong.service.CourseService;
import com.internet.jiaowuxitong.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse> implements StudentCourseService {

    @Autowired
    private CourseService courseService;



    @Override
    public List<Course> getCourse(Integer studentIdFromSession) {

        QueryWrapper<StudentCourse> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("student_id", studentIdFromSession);
        List<StudentCourse> studentCourses = baseMapper.selectList(queryWrapper);

        Course course = new Course();
        List<Course> list = new ArrayList<>();
        for(StudentCourse sc:studentCourses){

            QueryWrapper<Course> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("course_id",sc.getCourseId());
            Course course1 = courseService.getOne(queryWrapper1);
            list.add(course1);
        }
        return list;


    }

    /**
     * 查询成绩
     * @param studentIdFromSession
     * @return
     */
    @Override
    public List<CreditsInfoVo> getCredit(Integer studentIdFromSession) {
        QueryWrapper<StudentCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentIdFromSession);
        List<StudentCourse> studentCourses = baseMapper.selectList(queryWrapper);

        List<CreditsInfoVo> lists = new ArrayList<>();
        for(StudentCourse sc:studentCourses){
            QueryWrapper<Course> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("course_id",sc.getCourseId());
            Course course1 = courseService.getOne(queryWrapper1);

            CreditsInfoVo creditsInfoVo = new CreditsInfoVo();
            creditsInfoVo.setCourseName(course1.getName());
            creditsInfoVo.setCredit(course1.getCredit());
            lists.add(creditsInfoVo);
        }
        return lists;
    }


}
