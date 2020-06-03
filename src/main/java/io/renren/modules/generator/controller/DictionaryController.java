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
@RestController
@RequestMapping("generator/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:dictionary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictionaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:dictionary:info")
    public R info(@PathVariable("id") String id){
		DictionaryEntity dictionary = dictionaryService.getById(id);

        return R.ok().put("dictionary", dictionary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:dictionary:save")
    public R save(@RequestBody DictionaryEntity dictionary){
		dictionaryService.save(dictionary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:dictionary:update")
    public R update(@RequestBody DictionaryEntity dictionary){
		dictionaryService.updateById(dictionary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:dictionary:delete")
    public R delete(@RequestBody String[] ids){
		dictionaryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
