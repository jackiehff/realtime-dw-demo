package com.datafly.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datafly.generator.bean.ActivityRule;
import com.datafly.generator.mapper.ActivityRuleMapper;
import com.datafly.generator.service.ActivityRuleService;
import org.springframework.stereotype.Service;

/**
 * 活动规则服务实现类
 */
@Service
public class ActivityRuleServiceImpl extends ServiceImpl<ActivityRuleMapper, ActivityRule> implements ActivityRuleService {
}