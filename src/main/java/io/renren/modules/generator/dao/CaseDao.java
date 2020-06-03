package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.CaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Mapper
public interface CaseDao extends BaseMapper<CaseEntity> {
	
}
