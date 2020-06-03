package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CaseDetailsDao;
import io.renren.modules.generator.entity.CaseDetailsEntity;
import io.renren.modules.generator.service.CaseDetailsService;


@Service("caseDetailsService")
public class CaseDetailsServiceImpl extends ServiceImpl<CaseDetailsDao, CaseDetailsEntity> implements CaseDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CaseDetailsEntity> page = this.page(
                new Query<CaseDetailsEntity>().getPage(params),
                new QueryWrapper<CaseDetailsEntity>()
        );

        return new PageUtils(page);
    }

}