package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * ??Ʒ???????
 *
 * @author hm
 * @email sunlightcs@gmail.com
 * @date 2024-03-14 20:10:15
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenusByids(List<Long> catIds);
}

