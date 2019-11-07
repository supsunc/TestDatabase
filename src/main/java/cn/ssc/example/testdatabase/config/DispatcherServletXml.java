package cn.ssc.example.testdatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cn.ssc.example.testdatabase.controller")
public class DispatcherServletXml implements WebMvcConfigurer {
    /*
        <!-- 对模型视图名称的解析，即在模型视图名称添加前后缀(如果最后一个还是表示文件夹,则最后的斜杠不要漏了) 使用JSP-->
        <!-- 默认的视图解析器 在上边的解析错误时使用 (默认使用html)- -->
        <bean id="defaultViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
            <property name="prefix" value="/WEB-INF/WebContent/"/><!--设置JSP文件的目录位置-->
            <property name="suffix" value=".jsp"/>
            <property name="exposeContextBeansAsAttributes" value="true"/>
        </bean>
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setPrefix("/WEB-INF/WebContent/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 静态资源配置
    /*
        <mvc:resources mapping="css/**" location="/WEB-INF/WebContent/css/"/>
        <mvc:resources mapping="/js/**" location="/WEB-INF/WebContent/js/"/>
        <mvc:resources mapping="/images/**" location="/WEB-INF/WebContent/images/"/>
        <mvc:resources mapping="/site2/**" location="/WEB-INF/WebContent/site2/"/>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/WebContent/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/WebContent/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/WebContent/images/");
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/WebContent/");
    }

}
