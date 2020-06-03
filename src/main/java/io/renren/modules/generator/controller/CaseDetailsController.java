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

import io.renren.modules.generator.entity.CaseDetailsEntity;
import io.renren.modules.generator.service.CaseDetailsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 案例详情
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@RestController
@RequestMapping("generator/casedetails")
public class CaseDetailsController {
    @Autowired
    private CaseDetailsService caseDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:casedetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = caseDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:casedetails:info")
    public R info(@PathVariable("id") String id){
		CaseDetailsEntity caseDetails = caseDetailsService.getById(id);

        return R.ok().put("caseDetails", caseDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:casedetails:save")
    public R save(@RequestBody CaseDetailsEntity caseDetails){
		caseDetailsService.save(caseDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:casedetails:update")
    public R update(@RequestBody CaseDetailsEntity caseDetails){
		caseDetailsService.updateById(caseDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:casedetails:delete")
    public R delete(@RequestBody String[] ids){
		caseDetailsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
