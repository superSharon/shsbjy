package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.RemarkEntity;

import java.util.Map;

/**
 * 案例 设计师  资讯 内容
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface RemarkService extends IService<RemarkEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

