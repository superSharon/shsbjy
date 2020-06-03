package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 设计师详情
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:03
 */
@Data
@TableName("desion_works")
public class DesionWorksEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 设计师id
	 */
	private String designId;
	/**
	 * 作品名称
	 */
	private String worksName;
	/**
	 * 头像
	 */
	private String headUrl;
	/**
	 * 修改时间
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
