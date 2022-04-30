package com.internet.jiaowuxitong.controller;


//import com.internet.jiaowuxitong.common.R;


import com.internet.jiaowuxitong.common.R;
import com.internet.jiaowuxitong.common.utils.SessionUtils;
import com.internet.jiaowuxitong.entity.Course;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.vo.StudentInfoVo;
import com.internet.jiaowuxitong.service.StudentCourseService;
import com.internet.jiaowuxitong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//import com.internet.jiaowuxitong.entity.Course;
//import com.internet.jiaowuxitong.entity.Student;
//import com.internet.jiaowuxitong.service.StudentCourseService;
//import com.internet.jiaowuxitong.service.StudentService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentCourseService studentCourseSevice;

    @PostMapping("/login")
    public R login(@RequestParam("studentId")String studentId,
                   @RequestParam("identity")String identity, HttpSession session){

        Student login_student = studentService.login(studentId, identity);
        session.setAttribute("studentId",login_student.getStudentId());
        session.setAttribute("name",login_student.getName());
        return R.ok();

    }
    @PostMapping("/getCourse")
    public R getCourse(HttpSession session){
        Integer studentIdFromSession = SessionUtils.getStudentIdFromSession(session);
        List<Course> courses = studentCourseSevice.getCourse(studentIdFromSession);
        return R.ok().data("course",courses);

    }

    @PostMapping("/getAppend")
    public R getAppend(@RequestBody(required = true) StudentInfoVo studentInfoVo,HttpSession session){
        Integer studentIdFromSession = SessionUtils.getStudentIdFromSession(session);
        studentService.getAppend(studentInfoVo,studentIdFromSession);
        return R.ok();

    }

}

