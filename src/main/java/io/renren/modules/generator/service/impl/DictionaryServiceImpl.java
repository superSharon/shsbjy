package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.DictionaryDao;
import io.renren.modules.generator.entity.DictionaryEntity;
import io.renren.modules.generator.service.DictionaryService;


@Service("dictionaryService")
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, DictionaryEntity> implements DictionaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictionaryEntity> page = this.page(
                new Query<DictionaryEntity>().getPage(params),
                new QueryWrapper<DictionaryEntity>()
        );

        return new PageUtils(page);
    }

}