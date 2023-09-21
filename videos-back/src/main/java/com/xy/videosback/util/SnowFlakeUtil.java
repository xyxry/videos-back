package com.xy.videosback.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowFlakeUtil {
    private static final Snowflake snowflake = IdUtil.createSnowflake(1,1);
    public static long  getSnowflakeId() {
        return snowflake.nextId();
    }
}
