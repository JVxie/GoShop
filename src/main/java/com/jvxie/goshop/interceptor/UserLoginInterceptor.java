package com.jvxie.goshop.interceptor;


import com.jvxie.goshop.constants.CookieConstants;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.exception.UserLoginException;
import com.jvxie.goshop.model.User;
import com.jvxie.goshop.utils.CookieUtil;
import com.jvxie.goshop.vo.ResponseVo;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jvxie.goshop.constants.GoShopConstants.CUSTOMER;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从Cookies中获取token
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        if (cookie == null) throw new UserLoginException();
        // redis中获取token
        String token = redisTemplate.opsForValue().get(String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue()));
        // 对比token
        if (StringUtils.isEmpty(token)) throw new UserLoginException();
        // 对比成功刷新redis和cookie的时间
        return true;
    }
}
