package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.entity.InformationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资讯
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Mapper
public interface InformationDao extends BaseMapper<InformationEntity> {

    /**
     * 资讯
     * @param informationEntity
     * @return
     */
    List<InformationEntity> getInformationEntity(@Param("page")Page<InformationEntity> page,@Param("informationEntity")InformationEntity informationEntity);
	
}
