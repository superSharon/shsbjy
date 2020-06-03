package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 案例详情
 *
 * @author whh
 * @email whhacys@163.com
 * @date 2020-06-02 15:42:04
 */
@Data
@TableName("case_details")
public class CaseDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String id;
	/**
	 * 案例id
	 */
	private String cId;
	/**
	 * 小案例标题
	 */
	private String caseTitleName;
	/**
	 * 小案例logo
	 */
	private String caseTitleLogo;
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 创建名称
	 */
	private String creationName;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

}
