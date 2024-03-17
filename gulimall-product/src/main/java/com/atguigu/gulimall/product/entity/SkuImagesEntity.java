package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * skuͼƬ
 * 
 * @author hm
 * @email sunlightcs@gmail.com
 * @date 2024-03-14 20:10:15
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * ͼƬ??ַ
	 */
	private String imgUrl;
	/**
	 * ???
	 */
	private Integer imgSort;
	/**
	 * Ĭ??ͼ[0 - ????Ĭ??ͼ??1 - ??Ĭ??ͼ]
	 */
	private Integer defaultImg;

}
