package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.DesignDao;
import io.renren.modules.generator.entity.DesignEntity;
import io.renren.modules.generator.service.DesignService;


@Service("designService")
public class DesignServiceImpl extends ServiceImpl<DesignDao, DesignEntity> implements DesignService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DesignEntity> page = this.page(
                new Query<DesignEntity>().getPage(params),
                new QueryWrapper<DesignEntity>()
        );

        return new PageUtils(page);
    }

}