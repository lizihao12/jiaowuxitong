package com.internet.jiaowuxitong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.internet.jiaowuxitong.entity.Course;
import com.internet.jiaowuxitong.entity.StudentCourse;
import com.internet.jiaowuxitong.entity.vo.CreditsInfoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
public interface StudentCourseService extends IService<StudentCourse> {

    List<Course> getCourse(Integer studentIdFromSession);


    List<CreditsInfoVo> getCredit(Integer studentIdFromSession);

}
