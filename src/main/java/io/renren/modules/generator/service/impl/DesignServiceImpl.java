package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.entity.CaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private DesignDao designDao;
    /**
     * 设计展示
     * @param caseParam
     * @return
     */
    @Override
    public Page<DesignEntity> getDesignEntity(@Param("caseParam") DesignEntity caseParam){
        Page<DesignEntity> page = new Page<>(caseParam.getPage(), caseParam.getPageSize());
        page.setRecords(designDao.getDesignEntity(page,caseParam));
        return page;
    }

}