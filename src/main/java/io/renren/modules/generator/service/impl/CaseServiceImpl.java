package io.renren.modules.generator.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.model.params.CaseDetailsParam;
import io.renren.modules.generator.model.params.CaseParam;
import io.renren.modules.generator.model.params.RemarkParam;
import io.renren.modules.generator.model.result.CaseDetailsResult;
import io.renren.modules.generator.model.result.CaseResult;
import io.renren.modules.generator.model.result.RemarkResult;
import net.bytebuddy.asm.Advice;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityWriter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CaseDao;
import io.renren.modules.generator.entity.CaseEntity;
import io.renren.modules.generator.service.CaseService;


@Service
public class CaseServiceImpl extends ServiceImpl<CaseDao, CaseEntity> implements CaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CaseEntity> page = this.page(
                new Query<CaseEntity>().getPage(params),
                new QueryWrapper<CaseEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 案例接口
     */
    @Autowired
    private CaseDao caseDao;

    /**
     * 案例展示
     * @param caseParam
     * @return
     */
    @Override
   public Page<CaseEntity> getCaseList(@Param("caseParam") CaseEntity caseParam){
        QueryWrapper<CaseEntity> wrapper = new QueryWrapper<>();
        wrapper.setEntity(caseParam);
        Page<CaseEntity> page = new Page<>(caseParam.getPage(), caseParam.getPageSize());
        List<CaseEntity> staffList = caseDao.getCaseList(caseParam);
        return page.setRecords(staffList);
   }

    /**
     * 案例详情
     * @param caseDetailsParam
     * @return
     */
    @Override
    public List<CaseDetailsResult> getCaseDetails(CaseDetailsParam caseDetailsParam){
        List<CaseDetailsResult> list=null;
        try{
             list=caseDao.getCaseDetails(caseDetailsParam);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    /**
     *案例详情内容
     */
    @Override
    public List<RemarkResult> getRemarkResult(RemarkParam remarkParam){
        List<RemarkResult> list=null;
        try{
            list=caseDao.getRemarkResult(remarkParam);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

}