package com.internet.jiaowuxitong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.internet.jiaowuxitong.entity.Admin;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.vo.StudentsInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizihao
 * @since 2022-04-30
 */
public interface AdminService extends IService<Admin> {

    Admin login(String adminId, String password);

    List<StudentsInfoVo> getStudents(String adminId,long current,long limit);

    void deleteStudents(String adminId, String[] studentId);

    void updateStudents(String studentId,String adminId, StudentsInfoVo studentsInfoVo);
    //自定义的sql查询
    Boolean deleteAllStudents(@Param("studentIds") String[] studentIds);

    Student getStudent(String studentId, String adminId);
}
