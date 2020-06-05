package io.renren.modules.generator.model.result;


import lombok.Data;

import java.io.Serializable;

/**
 * 添加字典选择类别 下拉框
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
public class DictionarySel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别
     */
    private String category;
    /**
     * 描述
     */
    private String remarks;
}
