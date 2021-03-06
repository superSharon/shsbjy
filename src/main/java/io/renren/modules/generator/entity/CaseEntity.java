package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("`case`")
public class CaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "c_id", type = IdType.ID_WORKER)
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
	 * 简介
	 */
	private String caseSynopsis;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creationTime;
	/**
	 * 创建人
	 */
	private String creationName;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;


	/**
	 * 扩展字段 类别名称
	 */
	@TableField(exist = false)
	private String categoryName;

	/**
	 * 当前页数
	 */
	@TableField(exist = false)
	private Integer page;
	/**
	 * 显示条数
	 */
	@TableField(exist = false)
	private Integer pageSize;
	/**
	 * 图片url
	 */
	@TableField(exist = false)
	private String photoUrl;

}
