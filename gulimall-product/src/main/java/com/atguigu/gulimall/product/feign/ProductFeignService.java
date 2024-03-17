package com.atguigu.gulimall.product.feign;

import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author hhmm
 * @date 2024/3/15
 **/

@FeignClient("gulimall-product")
public interface ProductFeignService {
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params);
}
