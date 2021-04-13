package com.design.cloud.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author ezuy
 * @date 21/4/8 17:36
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsFilter() {

        CorsConfiguration configuration = new CorsConfiguration();
        // 是否允许携带cookie
        configuration.setAllowCredentials(true);
        // 可接受的域
        configuration.addAllowedOrigin("*");
        // 允许携带的头
        configuration.addAllowedHeader("*");
        // 允许访问的方式
        configuration.addAllowedMethod("*");

        // 基于url的跨域配置策略
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return new CorsWebFilter(source);
    }
}
