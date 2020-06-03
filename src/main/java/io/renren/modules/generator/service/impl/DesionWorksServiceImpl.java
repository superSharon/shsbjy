package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.DesionWorksDao;
import io.renren.modules.generator.entity.DesionWorksEntity;
import io.renren.modules.generator.service.DesionWorksService;


@Service("desionWorksService")
public class DesionWorksServiceImpl extends ServiceImpl<DesionWorksDao, DesionWorksEntity> implements DesionWorksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DesionWorksEntity> page = this.page(
                new Query<DesionWorksEntity>().getPage(params),
                new QueryWrapper<DesionWorksEntity>()
        );

        return new PageUtils(page);
    }

}