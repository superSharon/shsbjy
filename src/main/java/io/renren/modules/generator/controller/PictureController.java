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

import io.renren.modules.generator.entity.PictureEntity;
import io.renren.modules.generator.service.PictureService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 图片
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@RestController
@RequestMapping("generator/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:picture:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pictureService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:picture:info")
    public R info(@PathVariable("id") String id){
		PictureEntity picture = pictureService.getById(id);

        return R.ok().put("picture", picture);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:picture:save")
    public R save(@RequestBody PictureEntity picture){
		pictureService.save(picture);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:picture:update")
    public R update(@RequestBody PictureEntity picture){
		pictureService.updateById(picture);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:picture:delete")
    public R delete(@RequestBody String[] ids){
		pictureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
