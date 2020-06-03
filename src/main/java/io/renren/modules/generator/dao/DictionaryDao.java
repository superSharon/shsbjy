package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.DictionaryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Mapper
public interface DictionaryDao extends BaseMapper<DictionaryEntity> {
	
}
