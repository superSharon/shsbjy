package io.renren.modules.generator.model.params;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RemarkParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private String id;
    /**
     * 外键id
     */
    private String distinguishId;
    /**
     * 内容标题
     */
    private String contentTitle;
    /**
     * 内容
     */
    private String content;
    /**
     * 录入时间
     */
    private Date creationTime;
    /**
     * 录入人
     */
    private String creationName;
    /**
     * 修改时间
     */
    private Date modify;

    /**
     * 扩展字段 图片路径
     */
    private String photoUrl;

}