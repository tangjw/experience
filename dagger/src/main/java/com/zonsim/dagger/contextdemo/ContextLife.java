package com.zonsim.dagger.contextdemo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 自定义注解 Qualifier
 * Created by tang-jw on 2017/8/1.
 */

@Qualifier
@Documented     //文档提示作用
@Retention(RetentionPolicy.RUNTIME)     //注解范围是Runtime级别
public @interface ContextLife {
    
    String value() default "Application";   //默认值是 Application
    
}
