package cn.ssc.example.testdatabase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//        <?xml version="1.0" encoding="UTF-8"?>
//        <beans xmlns="http://www.springframework.org/schema/beans"
//                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//                xmlns:context="http://www.springframework.org/schema/context"
//                xsi:schemaLocation="http://www.springframework.org/schema/beans
//                http://www.springframework.org/schema/beans/spring-beans.xsd
//                http://www.springframework.org/schema/context
//                http://www.springframework.org/schema/context/spring-context.xsd">
//        <context:component-scan base-package="cn.b504"/>
//        </beans>
@Configuration
@ComponentScan(basePackages = {"cn.ssc.example"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class ApplicationContextXml {
}
