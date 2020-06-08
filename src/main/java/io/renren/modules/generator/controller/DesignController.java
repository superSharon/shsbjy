package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.GeneratID;
import io.renren.modules.generator.entity.CaseEntity;
import io.renren.modules.generator.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.DesignEntity;
import io.renren.modules.generator.service.DesignService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 设计师
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
@Api(value = "设计师")
@RestController
@RequestMapping("generator/design")
public class DesignController {
    @Autowired
    private DesignService designService;

    /**
     * 设计展示
     */
    @ApiOperation(value = "设计师前端展示")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "page", value = "当前页码", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "int")
    })
    @PostMapping("/designList")
    public R getDesignEntity(@RequestBody DesignEntity params){
        IPage<DesignEntity> staffList = designService.getDesignEntity(params);
        return R.ok().put("list",staffList);
    }



    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("后台列表")
    //@RequiresPermissions("generator:design:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = designService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("编辑")
    @GetMapping("/info")
    @ApiImplicitParam(paramType = "query",name = "id", value = "当前行id",  dataType = "int")
    //@RequiresPermissions("generator:design:info")
    public R info(String id){
		DesignEntity design = designService.getById(id);

        return R.ok().put("design", design);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增设计师")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "name", value = "设计师名称",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "headUrl", value = "设计师图片路径",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "desginIdea",value="设计师理念",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "honor",value="荣誉",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="录入人",dataType = "String")
    })
    //@RequiresPermissions("generator:design:save")
    public R save(@RequestBody DesignEntity design){
        design.setId(UUID.randomUUID().toString());
        design.setDesignNumber(GeneratID.getGeneratID().toString());
        design.setCreationTime(new Date());
		designService.save(design);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改设计师")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "设计师id  当前行id",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "name", value = "设计师名称",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "headUrl", value = "设计师图片路径",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "desginIdea",value="设计师理念",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "honor",value="荣誉",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="录入人",dataType = "String")
    })
    //@RequiresPermissions("generator:design:update")
    public R update(DesignEntity design){
        design.setModifyTime(new Date());
		designService.updateById(design);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @ApiImplicitParam(paramType = "query",name = "id", value = "当前行id",  dataType = "int")
    @GetMapping("/delete")
    //@RequiresPermissions("generator:design:delete")
    public R delete(String id){
		designService.removeByIds(Arrays.asList(id));

        return R.ok();
    }

}
