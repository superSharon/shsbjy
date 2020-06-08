package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.dao.DesignDao;
import io.renren.modules.generator.entity.DesignEntity;
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

    @Autowired
    private InformationDao informationDao;
    /**
     * 资讯展示
     * @param caseParam
     * @return
     */
    @Override
    public Page<InformationEntity> getInformationEntity(@Param("caseParam") InformationEntity caseParam){
        Page<InformationEntity> page = new Page<>(caseParam.getPage(), caseParam.getPageSize());
        page.setRecords(informationDao.getInformationEntity(page,caseParam));
        return page;
    }

}