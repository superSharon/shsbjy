package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 资讯
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("information")
public class InformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 类别
	 */
	private String informationNumber;
	/**
	 * 类型
	 */
	private String informationType;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 图片路径
	 */
	private String logoUrl;
	/**
	 * 发布时间
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


	/**
	 * 图片url
	 */
	private String photoUrl;
	/**
	 *
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
