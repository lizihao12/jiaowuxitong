package com.internet.jiaowuxitong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.internet.jiaowuxitong.common.handler.GuliException;
import com.internet.jiaowuxitong.entity.Admin;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.vo.StudentsInfoVo;
import com.internet.jiaowuxitong.mapper.AdminMapper;
import com.internet.jiaowuxitong.service.AdminService;
import com.internet.jiaowuxitong.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizihao
 * @since 2022-04-30
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private StudentService studentService;



    @Override
    public Admin login(String adminId, String password) {
        if(StringUtils.isEmpty(adminId) || StringUtils.isEmpty(password)){
            throw new GuliException(20001,"登录失败");
        }

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id",adminId);
        Admin admin = baseMapper.selectOne(queryWrapper);

        if(StringUtils.isEmpty(admin)){
            throw new GuliException(20001,"密码或账号错误");
        }


        String password_dbms = admin.getPassword();
        if(!password_dbms.equals(password)) {
            throw new GuliException(20001,"密码或账号错误");
        }
        return admin;
    }

    @Override
    public List<StudentsInfoVo> getStudents(String adminId,long current,long limit) {
        if(adminId == null){
            throw new GuliException(20001,"请先登录管理员账号");
        }

        //创建page
        Page<Student> pageStudent = new Page<>(current, limit);
        studentService.page(pageStudent,null);
        List<Student> lists = pageStudent.getRecords();
        long total = pageStudent.getTotal();
        System.out.println(total+"111111111111111"+lists);


//        List<Student> lists = studentService.list(null);
        List<StudentsInfoVo> listVo = new ArrayList<>();

//工具类，BeanUtils.copyProperties(courseInfoVo, eduCourse);
        for(Student student:lists){
            StudentsInfoVo studentsInfoVo = new StudentsInfoVo();
            studentsInfoVo.setAge(student.getAge());
            studentsInfoVo.setClasses(student.getClasses());
            studentsInfoVo.setGarde(student.getGarde());
            studentsInfoVo.setName(student.getName());
            studentsInfoVo.setMajor(student.getMajor());
            studentsInfoVo.setStudentId(student.getStudentId());
            listVo.add(studentsInfoVo);
        }
        return listVo;
    }
    //出错Parameter 'xxx' not found. Available parameters are [xxx]
    //加上@Param注解，与*.xml文件方法参数对应
    @Override
    public void deleteStudents(String adminId,@Param("studentIds") String[] studentIds) {
        if(adminId == null){
            throw new GuliException(20001,"请先登录管理员账号");
        }


//        Map<String,String> map = new HashMap<>();
//        for(int i = 0;i<studentIds.length;i++){
//            map.put("student_id",studentIds[i]);
//        }
//
//        System.out.println(map);
        Boolean b = baseMapper.deleteAllStudents(studentIds);

        if(!b){
            throw new GuliException(20001,"删除失败，请刷新页面");
        }


    }

    @Override
    public void updateStudents(String studentId,String adminId, StudentsInfoVo studentsInfoVo) {
        if(adminId == null){
            throw new GuliException(20001,"请先登录管理员账号");
        }
        //查询数据库是否存在修改的id
        String studentId_new = studentsInfoVo.getStudentId();
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId_new);
        Student one = studentService.getOne(queryWrapper);
        if(one != null){
            throw new GuliException(20001,"此学号重复，请换一个");
        }
        //修改数据
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("student_id",studentId);

        Student student = new Student();

        BeanUtils.copyProperties(studentsInfoVo, student);
        System.out.println(student);

        boolean update = studentService.update(student, updateWrapper);
        if(!update){
            throw new GuliException(20001,"更新数据出错");
        }

    }

    @Override
    public Boolean deleteAllStudents(String[] studentIds) {
        return baseMapper.deleteAllStudents(studentIds);
    }

    //查询一个
    @Override
    public Student getStudent(String studentId, String adminId) {
        if(adminId == null){
            throw new GuliException(20001,"请先登录管理员账号");
        }
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId);
        Student student = studentService.getOne(queryWrapper);
        if(student == null){
            throw new GuliException(20001,"参看失败，检查数据");
        }
        return student;

    }
}
