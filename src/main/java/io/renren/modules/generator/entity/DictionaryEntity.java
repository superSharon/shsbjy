package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("dictionary")
public class DictionaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 类别名称
	 */
	private String categoryName;
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
	private Date creationModify;

}
