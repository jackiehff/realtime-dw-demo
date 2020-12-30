package com.datafly.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datafly.generator.bean.SkuInfo;
import com.datafly.generator.mapper.SkuInfoMapper;
import com.datafly.generator.service.SkuInfoService;
import org.springframework.stereotype.Service;

/**
 * 库存单元服务实现类
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {
}
