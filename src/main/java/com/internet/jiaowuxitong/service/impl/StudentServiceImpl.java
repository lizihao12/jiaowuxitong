package com.internet.jiaowuxitong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.internet.jiaowuxitong.common.handler.GuliException;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.vo.StudentInfoVo;
import com.internet.jiaowuxitong.mapper.StudentMapper;
import com.internet.jiaowuxitong.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    @Override
    public Student login(String studentId, String identity) {
        if(StringUtils.isEmpty(studentId) || StringUtils.isEmpty(identity)){
            throw new GuliException(20001,"登录失败");
        }


        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId);
        Student student = baseMapper.selectOne(queryWrapper);
        if(StringUtils.isEmpty(student)){
            throw new GuliException(20001,"密码或账号错误");
        }

        //判断是否启用了新密码 0-默认密码，1-用新密码
        Integer passwordSign = student.getPasswordSign();
        if(passwordSign.equals(1)){
            String password = student.getPassword();
            if(!identity.equals(password)){
                throw new GuliException(20001,"密码或账号错误");
            }
            return student;
        }


        //数据库查询学号与identity
        String identity_dbms = student.getIdentity();
        //截取身份证后六位
        String new_identity_dbms = identity_dbms.substring(12);

        //String studentId_dbms = student.getStudentId();
        if(StringUtils.isEmpty(new_identity_dbms)) {
            throw new GuliException(20001,"密码或账号错误");
        }
        if(!new_identity_dbms.equals(identity)){
            System.out.println(new_identity_dbms+"===================="+identity);
            throw new GuliException(20001,"密码或账号错误");
        }
        return student;
    }

    /**
     * 追加学生数据
     * @param studentIdFromSession
     */
    @Override
    public void getAppend(StudentInfoVo studentInfoVo, Integer studentIdFromSession){

        if(StringUtils.isEmpty(studentIdFromSession)){
            throw new GuliException(20001,"请登录");
        }

        Student student = new Student();
        student.setAge(studentInfoVo.getAge());
        student.setContent(studentInfoVo.getIndroduction());
        student.setEmail(studentInfoVo.getEmail());
        student.setAge(studentInfoVo.getAge());
        student.setHobby(studentInfoVo.getInterset());
        //性别 0-男，1-女
        if(!studentInfoVo.getSex().isEmpty()){
            if(studentInfoVo.getSex() == "male"){
                student.setGender(0);
            }
            if(studentInfoVo.getSex() == "female"){
                student.setGender(1);
            }
        }
        if(!studentInfoVo.getPassword().isEmpty()){
            //0-默认密码，1-用新密码
            student.setPasswordSign(1);
            student.setPassword(studentInfoVo.getPassword());
        }
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("student_id",studentIdFromSession);
        int update = baseMapper.update(student,updateWrapper);
        if(update != 1 ){
            throw new GuliException(20001,"更新数据出现异常");
        }

    }


}
