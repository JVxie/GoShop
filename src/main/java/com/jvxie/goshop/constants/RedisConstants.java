package com.jvxie.goshop.constants;

import org.springframework.beans.factory.annotation.Value;

public class RedisConstants {
    public static final String TOKEN_PREFIX = "token_%s";
    public static final Integer TOKEN_EXPIRE = 259200;
}
