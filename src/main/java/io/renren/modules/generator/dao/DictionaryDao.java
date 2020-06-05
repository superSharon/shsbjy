package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.DictionaryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.model.result.DictionaryResult;
import io.renren.modules.generator.model.result.DictionarySel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Mapper
public interface DictionaryDao extends BaseMapper<DictionaryEntity> {

    /**
     * 前端 列表目录
     * @param category
     * @return
     */
    List<DictionaryResult> getDictionaryEntity(@Param("category") String category);

    /**
     * 添加字典选择类别 下拉框
     */
    List<DictionarySel> getDictionarySel();

}
