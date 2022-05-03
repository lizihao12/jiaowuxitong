package com.internet.jiaowuxitong.controller;


import com.internet.jiaowuxitong.common.R;
import com.internet.jiaowuxitong.common.utils.SessionUtils;
import com.internet.jiaowuxitong.entity.Task;
import com.internet.jiaowuxitong.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @since 2022-05-03
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    //发布信息
    @PostMapping("/releaseTask")
    public R releaseTask(@RequestBody Task task, HttpSession session){
        Integer studentIdFromSession = SessionUtils.getStudentIdFromSession(session);
        taskService.releaseTask(task,studentIdFromSession);
        return R.ok();

    }
    //获得发布信息
    @PostMapping("/getTask")
    public R getTask(){

        List<Task> lists = taskService.getTask();
        return R.ok().data("task",lists);

    }

}

