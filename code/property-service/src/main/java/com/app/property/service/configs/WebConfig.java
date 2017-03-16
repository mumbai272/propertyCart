//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.app.property.service.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc //mvc:annotation-driven
@Configuration
@ComponentScan({ "com.app.property.service.*" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
    
   
}
