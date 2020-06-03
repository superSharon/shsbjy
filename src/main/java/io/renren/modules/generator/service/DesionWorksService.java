package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.DesionWorksEntity;

import java.util.Map;

/**
 * 设计师详情
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
public interface DesionWorksService extends IService<DesionWorksEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

