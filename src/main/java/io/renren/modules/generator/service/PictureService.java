package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.PictureEntity;

import java.util.Map;

/**
 * 图片
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface PictureService extends IService<PictureEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

