package com.humor.activity.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean(new WebStatFilter());
        filter.addUrlPatterns("/*");
        filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filter;
    }

    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        ServletRegistrationBean servlet = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //白名单
        servlet.addInitParameter("allow","");
        //黑名单 优先级高
        servlet.addInitParameter("deny","");
        servlet.addInitParameter("loginUsername","humor");
        servlet.addInitParameter("loginPassword","123321!");
        //是否可重置
        servlet.addInitParameter("resetEnable","false");
        return servlet;
    }

}
