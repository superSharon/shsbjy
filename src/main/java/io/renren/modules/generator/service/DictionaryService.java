package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.DictionaryEntity;
import io.renren.modules.generator.model.result.DictionaryResult;
import io.renren.modules.generator.model.result.DictionarySel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface DictionaryService extends IService<DictionaryEntity> {

    PageUtils queryPage(Map<String, Object> params);

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

