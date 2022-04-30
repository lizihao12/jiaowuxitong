package com.internet.jiaowuxitong.controller;


import com.internet.jiaowuxitong.common.R;
import com.internet.jiaowuxitong.common.utils.SessionUtils;
import com.internet.jiaowuxitong.entity.vo.CreditsInfoVo;
import com.internet.jiaowuxitong.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizihao
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/getCredit")
    public R getCredit(HttpSession session){
        Integer studentIdFromSession = SessionUtils.getStudentIdFromSession(session);
        List<CreditsInfoVo> lists = studentCourseService.getCredit(studentIdFromSession);
        return R.ok().data("credit",lists);

    }

}

