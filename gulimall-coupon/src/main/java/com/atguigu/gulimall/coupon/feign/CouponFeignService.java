package com.atguigu.gulimall.coupon.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author hhmm
 * @date 2024/3/15
 **/
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
}
