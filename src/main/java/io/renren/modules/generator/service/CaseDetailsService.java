package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CaseDetailsEntity;

import java.util.Map;

/**
 * 案例详情
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface CaseDetailsService extends IService<CaseDetailsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

