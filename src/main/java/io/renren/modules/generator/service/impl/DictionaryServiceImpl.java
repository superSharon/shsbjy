package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.model.result.DictionaryResult;
import io.renren.modules.generator.model.result.DictionarySel;
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

    @Autowired
    private DictionaryDao dictionaryDao;
    /**
     * 前端 列表目录
     * @param category
     * @return
     */
    public List<DictionaryResult> getDictionaryEntity(@Param("category") String category){
        List<DictionaryResult> list=dictionaryDao.getDictionaryEntity(category);
        return list;
    }

    /**
     * 添加字典选择类别 下拉框
     */
   public List<DictionarySel> getDictionarySel(){
       List<DictionarySel> list=dictionaryDao.getDictionarySel();
       return  list;
   }

}