package com.TodoList.Springtodo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @ComponentScan --> @Componet어노테이션이 붙어있는 클래스를 자동으로 스프링 빈으로 등록한다.
@Configuration
@ComponentScan
public class AppConfig {}
