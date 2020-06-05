package io.renren.modules.generator.model.result;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 前端目录  下拉返回
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
public class DictionaryResult implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId
    private String id;
    /**
     * 类别名称
     */
    private String categoryName;

}
