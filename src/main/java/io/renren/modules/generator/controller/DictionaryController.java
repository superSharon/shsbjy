package io.renren.modules.generator.controller;

import java.util.*;

import io.renren.common.utils.GeneratID;
import io.renren.modules.generator.model.result.DictionaryResult;
import io.renren.modules.generator.model.result.DictionarySel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.DictionaryEntity;
import io.renren.modules.generator.service.DictionaryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 字典
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Api("字典")
@RestController
@RequestMapping("generator/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 案例列表
     */
    @ApiOperation("案例目录列表")
    @GetMapping("/caseSelect")
    public R caseSelect(){
        String category="10001";
        List<DictionaryResult> list=dictionaryService.getDictionaryEntity(category);
        return R.ok().put("list", list);
    }
    /**
     * 资讯列表
     */
    @ApiOperation("资讯目录列表")
    @GetMapping("/informationSelect")
    public R informationSelect(){
        String category="10002";
        List<DictionaryResult> list=dictionaryService.getDictionaryEntity(category);
        return R.ok().put("list", list);
    }

    /**
     * 案例列表
     */
    @ApiOperation("添加字典选择类别 下拉框")
    @GetMapping("/dictionarySel")
    public R getDictionarySel(){
        List<DictionarySel> list=dictionaryService.getDictionarySel();
        return R.ok().put("list", list);
    }

    /**
     * 列表
     */
    @ApiOperation("后端字典列表")
    @PostMapping("/list")
    //@RequiresPermissions("generator:dictionary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictionaryService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @GetMapping("/info")
    @ApiOperation(value = "编辑")
    @ApiImplicitParam(paramType = "query",name = "id", value = "当前行id",  dataType = "int")
    //@RequiresPermissions("generator:dictionary:info")
    public R info(String id){
		DictionaryEntity dictionary = dictionaryService.getById(id);

        return R.ok().put("dictionary", dictionary);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增字典")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "category", value = "字典类别",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "categoryName", value = "名称",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "remarks",value="备注",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="录入人",dataType = "String")
    })
    //@RequiresPermissions("generator:dictionary:save")
    public R save(DictionaryEntity dictionary){
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setCreationTime(new Date());
		dictionaryService.save(dictionary);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改字典")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "id",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "category", value = "字典类别",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "categoryName", value = "名称",  dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "remarks",value="备注",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "creationName",value="录入人",dataType = "String")
    })
    @PostMapping("/update")
    //@RequiresPermissions("generator:dictionary:update")
    public R update(DictionaryEntity dictionary){
        dictionary.setCreationModify(new Date());
		dictionaryService.updateById(dictionary);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除")
    @ApiImplicitParam(paramType = "query",name = "id", value = "当前行id",  dataType = "int")
    //@RequiresPermissions("generator:dictionary:delete")
    public R delete( String id){
		dictionaryService.removeByIds(Arrays.asList(id));

        return R.ok();
    }

}
