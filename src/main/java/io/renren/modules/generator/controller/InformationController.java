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
@RestController
@RequestMapping("generator/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:information:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = informationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:information:info")
    public R info(@PathVariable("id") String id){
		InformationEntity information = informationService.getById(id);

        return R.ok().put("information", information);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:information:save")
    public R save(@RequestBody InformationEntity information){
		informationService.save(information);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:information:update")
    public R update(@RequestBody InformationEntity information){
		informationService.updateById(information);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:information:delete")
    public R delete(@RequestBody String[] ids){
		informationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
