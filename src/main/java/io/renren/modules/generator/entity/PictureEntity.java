package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 图片
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("picture")
public class PictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 外键id  
	 */
	private String remarkId;
	/**
	 * 图片名称
	 */
	private String name;
	/**
	 * 路径
	 */
	private String url;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 创建人
	 */
	private String creationName;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

}
