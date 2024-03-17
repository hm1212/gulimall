package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.atguigu.gulimall.product.entity.CommentReplayEntity;

import com.atguigu.gulimall.common.utils.PageUtils;
import java.util.Map;

/**
 * ??Ʒ???ۻظ???ϵ
 *
 * @author hm
 * @email sunlightcs@gmail.com
 * @date 2024-03-14 20:10:15
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

