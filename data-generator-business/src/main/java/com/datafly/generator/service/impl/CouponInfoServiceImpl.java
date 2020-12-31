package com.datafly.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datafly.generator.bean.CouponInfo;
import com.datafly.generator.mapper.CouponInfoMapper;
import com.datafly.generator.service.CouponInfoService;
import org.springframework.stereotype.Service;

/**
 * 优惠券服务实现类
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
}