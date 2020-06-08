package io.renren.modules.generator.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.renren.common.utils.UploadUtils;
import io.renren.modules.generator.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.renren.common.utils.R;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author whh
 */
@Api(value = "文件控制类")
@RestController
@RequestMapping("generator/file/")
public class FileController {

    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "图片上传", notes = "图片上传")
    @PostMapping(value = "/uploadImg")
    @ResponseBody
    public R uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String url = this.uploadService.upload(file);
        if (StringUtils.isBlank(url)) {
            return R.error(1, "图片上传失败");
        }
        return R.ok(url);
    }

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

}
