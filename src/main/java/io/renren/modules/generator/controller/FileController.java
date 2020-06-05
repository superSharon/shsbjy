package io.renren.modules.generator.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.renren.common.utils.UploadUtils;
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

    @ApiOperation(value = "图片上传", notes = "图片上传")
    @PostMapping(value = "/uploadImg")
    public R uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        System.out.println(file);
        UploadUtils uploadUtils=new UploadUtils();
        String url = uploadUtils.upload(file);
        if (StringUtils.isBlank(url)) {
            return R.error(1, "图片上传失败");
        }
        return R.ok(url);
    }

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     *fastDFS服务器测试文件上传
     */
    @ApiOperation("astDFS服务器多文件上传")
    @PostMapping("/fastdfs")
    @ResponseBody
    public String fastdfs(@RequestParam(value = "test") MultipartFile test) throws IOException {

        //文件名
        String fileName=test.getOriginalFilename();
        //后缀名
        String extName=fileName.substring(fileName.lastIndexOf(".")+1);
        //四个参数（输入流，文件大小，后缀名，null）,返回一个路径
        StorePath storePath = fastFileStorageClient.uploadFile(test.getInputStream(),test.getSize(), extName, null);
        //不同路径
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
        System.out.println(storePath.getGroup());
        return "图片上传成功，并调皮的给您返回一个路径";
    }

    @ApiOperation("单文件")
    @PostMapping("/hsdjka")
    @ResponseBody
    public String fastdfs() throws FileNotFoundException {
        File file=new File("E://20180516113332205.PNG");
        //文件名
        String fileName=file.getName();
        //后缀名
        String extName=fileName.substring(fileName.lastIndexOf(".")+1);
        //创建流
        FileInputStream fileInputStream=new FileInputStream(file);
        //四个参数（输入流，文件大小，后缀名，null）,返回一个路径
        StorePath storePath = fastFileStorageClient.uploadFile(fileInputStream, file.length(), extName, null);
        //不同路径
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
        System.out.println(storePath.getGroup());
        return "图片上传成功，并调皮的给您返回一个路径";
    }
}
