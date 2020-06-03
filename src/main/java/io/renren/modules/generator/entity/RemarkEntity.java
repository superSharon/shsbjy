package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 案例 设计师  资讯 内容
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("remark")
public class RemarkEntity implements Serializable {
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

}
