package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CaseEntity;

import java.util.Map;

/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface CaseService extends IService<CaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

