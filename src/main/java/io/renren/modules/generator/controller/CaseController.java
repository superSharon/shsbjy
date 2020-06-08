package io.renren.modules.generator.controller;

import java.util.*;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.GeneratID;
import io.renren.modules.generator.model.params.CaseDetailsParam;
import io.renren.modules.generator.model.params.CaseParam;
import io.renren.modules.generator.model.params.RemarkParam;
import io.renren.modules.generator.model.result.CaseDetailsResult;
import io.renren.modules.generator.model.result.CaseResult;
import io.renren.modules.generator.model.result.RemarkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.CaseEntity;
import io.renren.modules.generator.service.CaseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Api(value = "案例")
@RestController
@RequestMapping("generator/case")
public class CaseController {
    @Autowired
    private CaseService caseService;
    /**
     * 案例展示
     */
    @ApiOperation(value = "案例前端展示")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query",name = "page", value = "当前页码",  dataType = "int"),
                         @ApiImplicitParam(paramType = "query",name = "pageSize", value = "每页条数",  dataType = "int"),
                         @ApiImplicitParam(paramType = "query",name = "caseCategory",
                                 value="类别：如当点击酒店空间或商业空间等 将对应的id值传过来",dataType = "String")
    })
    @PostMapping("/caseList")
    public R getCaseList(@RequestBody CaseEntity caseEntity){
        IPage<CaseEntity> iPage = caseService.getCaseList(caseEntity);
        iPage.getRecords();
        return R.ok().put("list",iPage);
    }

    /**
     * 信息
     */
    @ApiOperation(value = "编辑")
    @GetMapping("/info")
    @ApiImplicitParam(paramType = "query",name = "cId", value = "当前行id",  dataType = "int")
    //@RequiresPermissions("generator:case:info")
    public R info(String cId){
		CaseEntity caseList = caseService.getById(cId);
        return R.ok().put("case", caseList);
    }
    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增案例")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query",name = "caseCategory", value = "案例类别",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseTitle", value = "案例标题",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseLogo",value="类别图片",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseAddress",value="地址",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseSynopsis",value="简介",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="录入人",dataType = "String")
    })
    //@RequiresPermissions("generator:case:save")
    public R save(@RequestBody CaseEntity caseEntity){
        caseEntity.setCId(UUID.randomUUID().toString());
        caseEntity.setCaseNumber(GeneratID.getGeneratID().toString());
        caseEntity.setCreationTime(new Date());
		caseService.save(caseEntity);
        return R.ok();
    }
    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改案例")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "cId", value = "要修改行的数据id",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseCategory", value = "案例类别",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseTitle", value = "案例标题",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseLogo",value="类别图片",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseAddress",value="地址",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "caseSynopsis",value="简介",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="修改人",dataType = "String")
    })
    //@RequiresPermissions("generator:case:update")
    public R update(CaseEntity caseEntity){
        caseEntity.setModifyTime(new Date());
		caseService.updateById(caseEntity);
        return R.ok();
    }
    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @ApiImplicitParam(paramType = "query",name = "cId", value = "当前行id",  dataType = "int")
    @GetMapping("/delete")
    //@RequiresPermissions("generator:case:delete")
    public R delete(String cId){
		caseService.removeByIds(Arrays.asList(cId));
        return R.ok();
    }
    /**
     * 后台列表
     */
    @ApiOperation(value = "后台管理列表")
    @PostMapping("/list")
    //@RequiresPermissions("generator:case:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = caseService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 案例详情
     */
    @RequestMapping("/caseDetailsList")
    public R getCaseList(@RequestBody CaseDetailsParam params){
        List<CaseDetailsResult> list=caseService.getCaseDetails(params);
        return R.ok().put("list",list);
    }
    /**
     * 案例详情内容
     */
    @RequestMapping("/remarkList")
    public R getCaseList(@RequestBody RemarkParam params){
        List<RemarkResult> list=caseService.getRemarkResult(params);
        return R.ok().put("list",list);
    }

}
