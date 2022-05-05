package com.internet.jiaowuxitong.controller;


//import com.internet.jiaowuxitong.common.R;


import com.internet.jiaowuxitong.common.R;
import com.internet.jiaowuxitong.common.utils.SessionUtils;
import com.internet.jiaowuxitong.entity.Course;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.Task;
import com.internet.jiaowuxitong.entity.vo.StudentInfoVo;
import com.internet.jiaowuxitong.service.StudentCourseService;
import com.internet.jiaowuxitong.service.StudentService;
import com.internet.jiaowuxitong.service.TaskService;
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
@CrossOrigin //解决跨域
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentCourseService studentCourseSevice;


    /**
     * yh
     */

    @Autowired
    TaskService taskService;



    @PostMapping("/login")
    public R login(@RequestParam("studentId")String studentId,
                   @RequestParam("identity")String identity, HttpSession session){

        Student login_student = studentService.login(studentId, identity);
        session.setAttribute("studentId",login_student.getStudentId());
        session.setAttribute("name",login_student.getName());
        return R.ok();

    }
    @GetMapping("/getCourse")
    public R getCourse(HttpSession session){
        Integer studentIdFromSession = SessionUtils.getStudentIdFromSession(session);
        List<Course> courses = studentCourseSevice.getCourse(studentIdFromSession);
        return R.ok().data("course",courses);

    }
    /**
     * 追加学生数据
     */
    @PutMapping("/getAppend")
    public R getAppend(@RequestBody(required = true) StudentInfoVo studentInfoVo,HttpSession session){
        Integer studentIdFromSession = SessionUtils.getStudentIdFromSession(session);
        studentService.getAppend(studentInfoVo,studentIdFromSession);
        return R.ok();

    }
    /**
     * yh
     */
    @GetMapping("{college_id}")
    public List<Student> getstud(@PathVariable String college_id){
        return studentService.getstud(college_id);
    }

    @PutMapping
    public boolean publish(@RequestBody Task task){
        return taskService.save(task);
    }
    @PostMapping
    public List<Task> allpub(){
        return taskService.list(null);
    }

}

