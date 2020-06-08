package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.GeneratID;
import io.renren.modules.generator.entity.DesignEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.InformationEntity;
import io.renren.modules.generator.service.InformationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 资讯
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Api(value = "资讯")
@RestController
@RequestMapping("generator/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    /**
     * 资讯展示
     */
    @ApiOperation(value = "前端资讯展示")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "page", value = "当前页码", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "int")
    })
    @PostMapping("/informationList")
    public R getInformationEntity(@RequestBody InformationEntity params){
        IPage<InformationEntity> staffList = informationService.getInformationEntity(params);
        return R.ok().put("list",staffList);
    }



    /**
     * 列表
     */
    @ApiOperation(value = "后台列表")
    @PostMapping("/list")
    //@RequiresPermissions("generator:information:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = informationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info")
    @ApiOperation("编辑")
    @ApiImplicitParam(paramType = "query",name = "id", value = "当前行id",  dataType = "int")
    //@RequiresPermissions("generator:information:info")
    public R info(String id){
		InformationEntity information = informationService.getById(id);
        return R.ok().put("information", information);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增资讯")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "informationType", value = "资讯类别",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "title", value = "标题",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "content",value="内容",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "logoUrl",value="图片路径",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="录入人",dataType = "String")
    })
    //@RequiresPermissions("generator:information:save")
    public R save(InformationEntity information){
        information.setId(UUID.randomUUID().toString());
        information.setInformationNumber(GeneratID.getGeneratID().toString());
        information.setCreationTime(new Date());
		informationService.save(information);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改资讯")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "id",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "informationType", value = "资讯类别",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "title", value = "标题",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "content",value="内容",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "logoUrl",value="图片路径",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="修改人",dataType = "String")
    })
    //@RequiresPermissions("generator:information:update")
    public R update(InformationEntity information){
        information.setModifyTime(new Date());
		informationService.updateById(information);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除")
    @ApiImplicitParam(paramType = "query",name = "id", value = "当前行id",  dataType = "int")
    //@RequiresPermissions("generator:information:delete")
    public R delete(String id){
		informationService.removeByIds(Arrays.asList(id));

        return R.ok();
    }

}
