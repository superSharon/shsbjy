package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.PictureDao;
import io.renren.modules.generator.entity.PictureEntity;
import io.renren.modules.generator.service.PictureService;


@Service("pictureService")
public class PictureServiceImpl extends ServiceImpl<PictureDao, PictureEntity> implements PictureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PictureEntity> page = this.page(
                new Query<PictureEntity>().getPage(params),
                new QueryWrapper<PictureEntity>()
        );

        return new PageUtils(page);
    }

}