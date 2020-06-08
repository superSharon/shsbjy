package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.entity.DesignEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设计师
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
@Mapper
public interface DesignDao extends BaseMapper<DesignEntity> {

    /**
     * 设计
     * @param designEntity
     * @return
     */
    List<DesignEntity> getDesignEntity(@Param("page")Page<DesignEntity> page,@Param("designEntity") DesignEntity designEntity);
	
}
