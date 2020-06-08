package io.renren.modules.generator.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.renren.common.utils.UploadUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    @Value("${image.adress}")
    private String imageAdress;

    private static final List<String> ALLOW_TYPES = Arrays.asList("image/png", "image/jpeg",
            "image/jpg", "image/gif", "image/psd", "image/pdd", "audio/mp3", "audio/aac", "audio/mpeg");

    private static final Logger logger = LoggerFactory.getLogger(UploadUtils.class);

    /**
     * 支持的图片类型
     */
    private static final String[] SUPPORT_IMAGE_TYPE = {"JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP","jpg","jpeg","png","gif","bmp","wbmp"};
    private static final List<String> SUPPORT_IMAGE_LIST = Arrays.asList(SUPPORT_IMAGE_TYPE);

    @Autowired
    private FastFileStorageClient storageClient;

    public String upload(MultipartFile file) {
        try {
            // 1、文件的校验
            // 1.1.校验文件类型
            String contentType = file.getContentType();
            if (!ALLOW_TYPES.contains(contentType)) {
                // 类型不匹配，直接返回null
                return null;
            }
            // 2、保存到某个位置
            //file.transferTo(new File("E:\\heima", file.getOriginalFilename()));
            StorePath storePath;
            if (SUPPORT_IMAGE_LIST.contains(getExtension(file.getOriginalFilename()))) {
                //文件图片上传
                storePath = this.storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), getExtension(file.getOriginalFilename()), null);
            } else {
                //普通文件上传
                storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), getExtension(file.getOriginalFilename()), null);
            }
            // 3、生成图片地址
            String url = imageAdress + storePath.getFullPath();
            return url;
        } catch (Exception e) {
            logger.error("文件上传失败：文件名：{}", file.getOriginalFilename(), e);
            return null;
        }
    }
    public String getExtension(String fileName) {
        return StringUtils.substringAfterLast(fileName, ".");
    }
}
