package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CaseDao;
import io.renren.modules.generator.entity.CaseEntity;
import io.renren.modules.generator.service.CaseService;


@Service("caseService")
public class CaseServiceImpl extends ServiceImpl<CaseDao, CaseEntity> implements CaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CaseEntity> page = this.page(
                new Query<CaseEntity>().getPage(params),
                new QueryWrapper<CaseEntity>()
        );

        return new PageUtils(page);
    }

}