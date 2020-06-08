package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.entity.CaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.model.params.CaseDetailsParam;
import io.renren.modules.generator.model.params.CaseParam;
import io.renren.modules.generator.model.params.RemarkParam;
import io.renren.modules.generator.model.result.CaseDetailsResult;
import io.renren.modules.generator.model.result.CaseResult;
import io.renren.modules.generator.model.result.RemarkResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Mapper
public interface CaseDao extends BaseMapper<CaseEntity> {

    /**
     * 案例展示
     * @param caseParam
     * @return
     */
    List<CaseEntity> getCaseList(@Param("page") Page<CaseEntity> page,@Param("caseParam") CaseEntity caseParam);

    /**
     * 案例详情
     * @param caseDetailsParam
     * @return
     */
    List<CaseDetailsResult> getCaseDetails(CaseDetailsParam caseDetailsParam);

    /**
     *案例详情内容
     */
    List<RemarkResult> getRemarkResult(RemarkParam remarkParam);
}
