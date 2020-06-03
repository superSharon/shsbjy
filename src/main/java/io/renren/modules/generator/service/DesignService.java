package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.DesignEntity;

import java.util.Map;

/**
 * 设计师
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
public interface DesignService extends IService<DesignEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

