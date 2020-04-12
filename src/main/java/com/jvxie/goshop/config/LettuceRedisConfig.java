package com.jvxie.goshop.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class LettuceRedisConfig {

    @Bean
    public StringRedisTemplate redisTemplateLocal(
            @Value("${spring.redis.lettuce.pool.max-active}") int maxActive,
            @Value("${spring.redis.lettuce.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.lettuce.pool.min-idle}") int minIdle,
            @Value("${spring.redis.local.database}") int database,
            @Value("${spring.redis.local.timeout}") long timeout,
            @Value("${spring.redis.local.host}") String hostName,
            @Value("${spring.redis.local.port}") int port
    ) {

        /* ========= 基本配置 ========= */
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        configuration.setDatabase(database);
        /* ========= 连接池通用配置 ========= */
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxTotal(maxActive);
        /* ========= lettuce pool ========= */
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(genericObjectPoolConfig);
        builder.commandTimeout(Duration.ofSeconds(timeout));

        LettuceConnectionFactory connectionFactory  = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();
        return createRedisTemplate(connectionFactory);
    }

    @Bean
    public StringRedisTemplate redisTemplateUser(
            @Value("${spring.redis.lettuce.pool.max-active}") int maxActive,
            @Value("${spring.redis.lettuce.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.lettuce.pool.min-idle}") int minIdle,
            @Value("${spring.redis.user.database}") int database,
            @Value("${spring.redis.user.timeout}") long timeout,
            @Value("${spring.redis.user.host}") String hostName,
            @Value("${spring.redis.user.port}") int port
    ) {

        /* ========= 基本配置 ========= */
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        configuration.setDatabase(database);
        /* ========= 连接池通用配置 ========= */
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxTotal(maxActive);
        /* ========= lettuce pool ========= */
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(genericObjectPoolConfig);
        builder.commandTimeout(Duration.ofSeconds(timeout));

        LettuceConnectionFactory connectionFactory  = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();
        return createRedisTemplate(connectionFactory);
    }

    @Bean
    public StringRedisTemplate redisTemplateShopCar(
            @Value("${spring.redis.lettuce.pool.max-active}") int maxActive,
            @Value("${spring.redis.lettuce.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.lettuce.pool.min-idle}") int minIdle,
            @Value("${spring.redis.shop-car.database}") int database,
            @Value("${spring.redis.shop-car.timeout}") long timeout,
            @Value("${spring.redis.shop-car.host}") String hostName,
            @Value("${spring.redis.shop-car.port}") int port
    ) {

        /* ========= 基本配置 ========= */
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        configuration.setDatabase(database);
        /* ========= 连接池通用配置 ========= */
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxTotal(maxActive);
        /* ========= lettuce pool ========= */
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(genericObjectPoolConfig);
        builder.commandTimeout(Duration.ofSeconds(timeout));

        LettuceConnectionFactory connectionFactory  = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();
        return createRedisTemplate(connectionFactory);
    }

    public StringRedisTemplate createRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
