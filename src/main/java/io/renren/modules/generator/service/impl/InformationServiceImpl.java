package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.InformationDao;
import io.renren.modules.generator.entity.InformationEntity;
import io.renren.modules.generator.service.InformationService;


@Service("informationService")
public class InformationServiceImpl extends ServiceImpl<InformationDao, InformationEntity> implements InformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InformationEntity> page = this.page(
                new Query<InformationEntity>().getPage(params),
                new QueryWrapper<InformationEntity>()
        );

        return new PageUtils(page);
    }

}