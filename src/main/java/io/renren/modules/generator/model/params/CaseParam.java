package io.renren.modules.generator.model.params;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author whh
 */
@Data
public class CaseParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *id
     */
    @TableId
    private String cId;
    /**
     * 编号
     */
    private String caseNumber;
    /**
     * 案例类别
     */
    private String caseCategory;
    /**
     * 案例标题
     */
    private String caseTitle;
    /**
     * 案例logo图
     */
    private String caseLogo;

    /**
     * 地址
     */
    private String caseAddress;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTime;
    /**
     * 创建人
     */
    private String creationName;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 扩展字段 类别名称
     */
    private String categoryName;

    /**
     * 当前页数
     */
    private Integer page;
    /**
     * 显示条数
     */
    private Integer pageSize;
}