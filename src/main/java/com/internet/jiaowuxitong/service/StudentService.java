package com.internet.jiaowuxitong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.vo.StudentInfoVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
public interface StudentService extends IService<Student> {

    Student login(String studentId, String identity);

    void getAppend(StudentInfoVo studentInfoVo, Integer studentIdFromSession);


}
