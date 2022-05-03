package com.internet.jiaowuxitong.service;

import com.internet.jiaowuxitong.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizihao
 * @since 2022-05-03
 */
public interface TaskService extends IService<Task> {

    void releaseTask(Task task,Integer studentIdFromSession);

    List<Task> getTask();
}
