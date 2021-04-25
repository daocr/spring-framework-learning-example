package com.huilong.lettuce.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * 配置  CaffeineConfig
 * <p>
 * https://www.cnblogs.com/chenkeyu/p/8028781.html
 *
 * @author daocr
 * @date 2021/4/23
 */
@Configuration
@EnableCaching
public class RedisLettuceConfig {


    @Bean("myCache")
    public RedisCacheManager redisCache(@Autowired LettuceConnectionFactory lettuceConnectionFactory) {

        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(lettuceConnectionFactory);

        // 序列化配置
        RedisSerializationContext<Object, Object> redisSerializationContext = RedisSerializationContext.java();
        RedisSerializationContext.SerializationPair<Object> valueSerializationPair = redisSerializationContext.getValueSerializationPair();

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(valueSerializationPair)

                .entryTtl(Duration.ofMinutes(10));

        RedisCacheManager build = RedisCacheManager.builder(lettuceConnectionFactory)
                .cacheWriter(redisCacheWriter)
                .cacheDefaults(redisCacheConfiguration)
                .build();


        return build;
    }


    /**
     * 配置 redis 链接信息
     *
     * @return
     * @see org.springframework.data.redis.connection.RedisStandaloneConfiguration 单机
     * @see org.springframework.data.redis.connection.RedisSentinelConfiguration   哨兵
     * @see org.springframework.data.redis.connection.RedisClusterConfiguration    集群
     */
    @Bean
    public LettuceConnectionFactory jedisConnectionFactory() {

        // 配置 redis 服务器地址
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);


        /*****  客户端 配置 例如连接池  、 序列化 等 **/
//        LettuceClientConfiguration.LettuceClientConfigurationBuilder clientConfig = LettuceClientConfiguration.builder();

        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder clientConfig = LettucePoolingClientConfiguration.builder();


        // 线程池配置
        GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxIdle(5);
        clientConfig.poolConfig(poolConfig);


        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfig.build());


        return lettuceConnectionFactory;
    }


}
