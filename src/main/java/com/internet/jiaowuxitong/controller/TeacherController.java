package com.internet.jiaowuxitong.controller;


import com.internet.jiaowuxitong.entity.Teacher;
import com.internet.jiaowuxitong.entity.Teacher_course;
import com.internet.jiaowuxitong.service.ClassService;
import com.internet.jiaowuxitong.service.StudentService;
import com.internet.jiaowuxitong.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */

/**
 * yh
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin //解决跨域
public class TeacherController {

    @Autowired
    TeachService teachService;

    @Autowired
    ClassService classService;

    @Autowired
    StudentService studentService;

    @GetMapping("{teacher_id}/{password}")
    public Teacher getByLg(@PathVariable String teacher_id, @PathVariable  String password){
//        String str = identify.substring(identify.length() -6,identify.length());
//        System.out.println(str);
        return teachService.getTeacher(teacher_id,password);
    }
    @PutMapping
    public boolean register(@RequestBody Teacher teacher){
        return teachService.save(teacher);
    }

    @GetMapping("{teacherid}")
    public List<Teacher_course> geclass(@PathVariable String teacherid){
        return classService.getclass(teacherid);
    }

    //    @GetMapping("{college_id}")
//    public List<Student> gestud(@PathVariable String college_id){
//        return studentService.getstud(college_id);
//    }
    @PutMapping("{teacher_id}/{password}")
    public boolean updatepass(@PathVariable String teacher_id,@PathVariable String password){
        return teachService.uppassword(teacher_id,password);
    }

}

