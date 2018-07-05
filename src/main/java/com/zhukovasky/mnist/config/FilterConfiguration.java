package com.zhukovasky.mnist.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



/**
 * 2017/3/10.
 */
@Configuration
public class FilterConfiguration {




    private CorsConfiguration buildConfig() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许请求发送Cookie
        corsConfiguration.setAllowCredentials(true);
        // 原始请求的域名
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        // 添加请求头字段
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // 服务器支持的所有跨域请求的方法
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);

        // 预检请求的有效期，单位为秒。
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

    /**
     * 跨域过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //放开/api/open/**的跨域控制
        source.registerCorsConfiguration("/**", buildConfig());
        CorsFilter corsFilter = new CorsFilter(source);
     
        return new FilterRegistrationBean(corsFilter);
    }


}
