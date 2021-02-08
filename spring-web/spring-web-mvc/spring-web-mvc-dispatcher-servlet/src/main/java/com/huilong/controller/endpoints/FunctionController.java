package com.huilong.controller.endpoints;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

import java.util.Map;

/**
 * 函数式 注册和使用
 *
 * @author daocr
 * @date 2021/1/21
 */
@Configuration
@Slf4j
public class FunctionController {

    @Bean
    public RouterFunction<ServerResponse> router() {


        RouterFunctions.Builder route = RouterFunctions.route();


        return route
                // 注册 route ，可以理解为 @RequestMapping 注解的作用
                .GET("/simple", new SimpleHandler())
                // 拦截器
                .filter((request, next) -> {
                    log.info("simple  filter ");
                    return next.handle(request);
                })
                // 前置处理
                .before((request) -> {
                    log.info("simple  before ");
                    return request;
                })
                //后置处理
                .after((request, response) -> {
                    log.info("simple  after ");
                    return response;
                })
                .build();
    }


    public static class SimpleHandler implements HandlerFunction<ServerResponse> {
        @Override
        public ServerResponse handle(ServerRequest request) throws Exception {

            log.info("触发 handle");
            return ServerResponse.ok()
                    .header("Content-Type", "application/json")
                    .body(Map.of("hello", "world"));
        }
    }


}
