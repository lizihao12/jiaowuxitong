package com.internet.jiaowuxitong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.internet.jiaowuxitong.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lizihao
 * @since 2022-04-30
 */
public interface AdminMapper extends BaseMapper<Admin> {
    Boolean deleteAllStudents(@Param("studentIds") String[] studentIds);

}
