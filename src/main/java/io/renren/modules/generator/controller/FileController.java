package io.renren.modules.generator.controller;

import io.renren.common.utils.UploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import io.renren.common.utils.R;
import org.apache.commons.lang3.StringUtils;
/**
 * @author whh
 */
@Api(value = "文件控制类")
@RestController
@RequestMapping("generator/file/")
public class FileController {

    @ApiOperation(value = "图片上传", notes = "图片上传")
    @PostMapping(value = "/uploadImg")
    public R uploadImg(@RequestParam("file") MultipartFile file) {

        System.out.println(file);
        UploadUtils uploadUtils=new UploadUtils();
        String url = uploadUtils.upload(file);
        if (StringUtils.isBlank(url)) {
            return R.error(1, "图片上传失败");
        }
        return R.ok(url);
    }
}
