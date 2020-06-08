package io.renren.modules.generator.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "filepath")
@Configuration
public class FilePathProperties {

    private String imgpath;
    private String vediopath;
    private String basepath;
}
