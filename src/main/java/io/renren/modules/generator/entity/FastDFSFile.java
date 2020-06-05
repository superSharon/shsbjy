package io.renren.modules.generator.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FastDFSFile implements Serializable {

    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;
    private String height;
}
