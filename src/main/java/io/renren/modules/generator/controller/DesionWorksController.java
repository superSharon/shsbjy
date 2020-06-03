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

import io.renren.modules.generator.entity.DesionWorksEntity;
import io.renren.modules.generator.service.DesionWorksService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 设计师详情
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
@RestController
@RequestMapping("generator/desionworks")
public class DesionWorksController {
    @Autowired
    private DesionWorksService desionWorksService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:desionworks:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = desionWorksService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:desionworks:info")
    public R info(@PathVariable("id") String id){
		DesionWorksEntity desionWorks = desionWorksService.getById(id);

        return R.ok().put("desionWorks", desionWorks);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:desionworks:save")
    public R save(@RequestBody DesionWorksEntity desionWorks){
		desionWorksService.save(desionWorks);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:desionworks:update")
    public R update(@RequestBody DesionWorksEntity desionWorks){
		desionWorksService.updateById(desionWorks);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:desionworks:delete")
    public R delete(@RequestBody String[] ids){
		desionWorksService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
