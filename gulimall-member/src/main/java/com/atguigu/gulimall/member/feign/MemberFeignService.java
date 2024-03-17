package com.atguigu.gulimall.member.feign;

import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author hhmm
 * @date 2024/3/15
 **/
@FeignClient("gulimall-member")
public interface MemberFeignService {

    @GetMapping("/member/member/test")
    public R list();
}
