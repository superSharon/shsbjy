package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	@TableId
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
	private Date modifyTime;

}
