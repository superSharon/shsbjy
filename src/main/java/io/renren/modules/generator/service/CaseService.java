package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CaseEntity;
import io.renren.modules.generator.model.params.CaseDetailsParam;
import io.renren.modules.generator.model.params.CaseParam;
import io.renren.modules.generator.model.params.RemarkParam;
import io.renren.modules.generator.model.result.CaseDetailsResult;
import io.renren.modules.generator.model.result.CaseResult;
import io.renren.modules.generator.model.result.RemarkResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
public interface CaseService extends IService<CaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 案例展示
     * @param caseParam
     * @return
     */
    Page<CaseEntity> getCaseList(@Param("caseParam") CaseEntity caseParam);




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

