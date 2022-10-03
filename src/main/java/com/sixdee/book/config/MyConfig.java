package com.sixdee.book.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;

@Configuration
//@EnableJpaRepositories
public class MyConfig implements WebMvcConfigurer{
public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argResolver) {
	argResolver.add(new SpecificationArgumentResolver());
}
}
