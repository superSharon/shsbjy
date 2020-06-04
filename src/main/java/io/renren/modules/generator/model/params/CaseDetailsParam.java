package io.renren.modules.generator.model.params;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author whh
 */
@Data
public class CaseDetailsParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private String id;
    /**
     * 案例id
     */
    private String cId;
    /**
     * 小案例标题
     */
    private String caseTitleName;
    /**
     * 小案例logo
     */
    private String caseTitleLogo;
    /**
     * 创建时间
     */
    private Date creationTime;
    /**
     * 创建名称
     */
    private String creationName;
    /**
     * 修改时间
     */
    private Date modifyTime;

}