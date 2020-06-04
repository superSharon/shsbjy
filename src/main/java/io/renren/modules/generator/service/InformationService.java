package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.InformationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 资讯
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface InformationService extends IService<InformationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 资讯
     * @param informationEntity
     * @return
     */
    Page<InformationEntity> getInformationEntity(@Param("informationEntity") InformationEntity informationEntity);
}

