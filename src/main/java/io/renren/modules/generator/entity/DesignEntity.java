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
 * 设计师
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
@Data
@TableName("design")
public class DesignEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	private String id;
	/**
	 * 编号
	 */
	private String designNumber;
	/**
	 * 设计师
	 */
	private String name;
	/**
	 * 头像路径
	 */
	private String headUrl;
	/**
	 * 理念
	 */
	private String desginIdea;
	/**
	 * 荣誉
	 */
	private String honor;
	/**
	 * 录入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creationTime;
	/**
	 * 录入人
	 */
	private String creationName;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;

	/**
	 * 图片url
	 */
	@TableField(exist = false)
	private String photoUrl;

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

}
