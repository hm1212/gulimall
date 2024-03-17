package com.atguigu.gulimall.order.feigen;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author hhmm
 * @date 2024/3/15
 **/

@FeignClient("gulimall-order")
public interface OrderFeignService {
}
