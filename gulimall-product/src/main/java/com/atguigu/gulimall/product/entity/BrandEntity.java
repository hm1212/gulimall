package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.zip.ZipEntry;

/**
 * Ʒ?
 * 
 * @author hm
 * @email sunlightcs@gmail.com
 * @date 2024-03-14 20:10:15
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long brandId;
	/**
	 *
	 */
	@NotNull(message = "品牌名不能为空")
	private String name;
	/**
	 *
	 */
	@NotNull
	@URL(message = "logo必须是有效的链接地址")
	private String logo;
	/**
	 *
	 */
	private String descript;
	/**
	 *
	 */
	private Integer showStatus;
	/**
	 *
	 */
	@Pattern(regexp = "/^[A-Za-z]$/",message = "检验首字母必须是一个字母")
	private String firstLetter;
	/**
	 *
	 */
	@Min(value = 0,message = "排序必须大于等于0")
	private Integer sort;

}
