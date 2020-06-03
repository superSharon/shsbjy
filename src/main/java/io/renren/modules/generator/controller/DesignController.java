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
@RestController
@RequestMapping("generator/design")
public class DesignController {
    @Autowired
    private DesignService designService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:design:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = designService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:design:info")
    public R info(@PathVariable("id") String id){
		DesignEntity design = designService.getById(id);

        return R.ok().put("design", design);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:design:save")
    public R save(@RequestBody DesignEntity design){
		designService.save(design);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:design:update")
    public R update(@RequestBody DesignEntity design){
		designService.updateById(design);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:design:delete")
    public R delete(@RequestBody String[] ids){
		designService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
