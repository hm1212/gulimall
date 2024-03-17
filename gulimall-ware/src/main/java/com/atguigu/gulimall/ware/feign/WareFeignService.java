package com.atguigu.gulimall.ware.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author hhmm
 * @date 2024/3/15
 **/

@FeignClient("gulimall-ware")
public interface WareFeignService {
}
