package com.internet.jiaowuxitong.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.internet.jiaowuxitong.common.R;
import com.internet.jiaowuxitong.common.utils.SessionUtils;
import com.internet.jiaowuxitong.entity.Admin;
import com.internet.jiaowuxitong.entity.Student;
import com.internet.jiaowuxitong.entity.Teacher;
import com.internet.jiaowuxitong.entity.Teacher_course;
import com.internet.jiaowuxitong.entity.vo.StudentsInfoVo;
import com.internet.jiaowuxitong.service.AdminService;
import com.internet.jiaowuxitong.service.ClassService;
import com.internet.jiaowuxitong.service.StudentService;
import com.internet.jiaowuxitong.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizihao
 * @since 2022-04-30
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin //解决跨域
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    /**
     * yh
     */
    @Autowired
    private TeachService teachService;

    @Autowired
    private ClassService classService;

    @PostMapping("/login")
    public R login(@RequestParam("adminId")String adminId,
                   @RequestParam("password")String password, HttpSession session){

        Admin login_admin = adminService.login(adminId, password);
        session.setAttribute("adminId",login_admin.getAdminId());
        return R.ok();

    }

    /**
     *
     * @param current 当前页
     * @param limit 每页记录情况
     * @param session
     * @return
     */
    //参看全部的
    @GetMapping("/getStudents/{current}/{limit}")
    public R getStudents(@PathVariable Long current,
                       @PathVariable Long limit,HttpSession session){

//        //创建page
        Page<Student> pageStudent = new Page<>(current, limit);
        studentService.page(pageStudent,null);
        String adminId = SessionUtils.getAdminIdFromSession(session);
        List<StudentsInfoVo> lists = adminService.getStudents(adminId,current,limit);
        return R.ok().data("StudentsInfoVo",lists);
    }

    //批量删除
    @DeleteMapping("/deleteStudents")
    public R deleteStudents(
            @RequestParam String[] studentIds, HttpSession session){

//      //创建page

        String adminId = SessionUtils.getAdminIdFromSession(session);
        adminService.deleteStudents(adminId,studentIds);

        return R.ok();
    }
    //修改
    @PutMapping("/updateStudents/{studentId}")
    public R updateStudents(@PathVariable String studentId,
            @RequestBody StudentsInfoVo studentsInfoVo,HttpSession session){

        String adminId = SessionUtils.getAdminIdFromSession(session);
        adminService.updateStudents(studentId,adminId,studentsInfoVo);
        return R.ok();
    }

    //查看一个学生
    @GetMapping("/getStudent/{studentId}")
    public R getStudent(@PathVariable String studentId,
                            HttpSession session){

        String adminId = SessionUtils.getAdminIdFromSession(session);
        Student student = adminService.getStudent(studentId, adminId);
        return R.ok().data("student",student);
    }


    /**
     * yh
     */


    @PostMapping
    public boolean updateT(@RequestBody Teacher teacher){
        return teachService.updateById(teacher);
    }

    @PostMapping("/xxx")
    public boolean updateC(@RequestBody Teacher_course teacher_course){
        return classService.updateById(teacher_course);
    }
}

