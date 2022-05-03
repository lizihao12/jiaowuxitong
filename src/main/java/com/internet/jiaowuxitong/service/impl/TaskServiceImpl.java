package com.internet.jiaowuxitong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.internet.jiaowuxitong.common.handler.GuliException;
import com.internet.jiaowuxitong.entity.Task;
import com.internet.jiaowuxitong.mapper.TaskMapper;
import com.internet.jiaowuxitong.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizihao
 * @since 2022-05-03
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Override
    public void releaseTask(Task task,Integer studentIdFromSession) {
        if(StringUtils.isEmpty(studentIdFromSession)){
            throw new GuliException(20001,"请登录");
        }

        int insert = baseMapper.insert(task);
        if(insert == 0){
            throw new GuliException(20001,"发布失败");
        }

    }

    @Override
    public List<Task> getTask() {
        List<Task> tasks = baseMapper.selectList(null);
        return tasks;
    }
}
