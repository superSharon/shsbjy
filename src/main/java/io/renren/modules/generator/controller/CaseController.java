package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("generator/case")
public class CaseController {
    @Autowired
    private CaseService caseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:case:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = caseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cId}")
    @RequiresPermissions("generator:case:info")
    public R info(@PathVariable("cId") String cId){
		CaseEntity caseList = caseService.getById(cId);

        return R.ok().put("case", caseList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:case:save")
    public R save(@RequestBody CaseEntity caseEntity){
		caseService.save(caseEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:case:update")
    public R update(@RequestBody CaseEntity caseEntity){
		caseService.updateById(caseEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:case:delete")
    public R delete(@RequestBody String[] cIds){
		caseService.removeByIds(Arrays.asList(cIds));

        return R.ok();
    }

}
