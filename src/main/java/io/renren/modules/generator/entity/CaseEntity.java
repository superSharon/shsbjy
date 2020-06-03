package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 案例表
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("case")
public class CaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
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
