package cn.ssc.example.testdatabase.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.beans.PropertyVetoException;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = "cn.ssc.example.testdatabase.mapper")
public class ApplicationConfig {

    @Bean
    ComboPooledDataSource comboPooledDataSource(DatabaseProperties databaseProperties) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(databaseProperties.getDriver());
        comboPooledDataSource.setJdbcUrl(databaseProperties.getUrl());
        comboPooledDataSource.setUser(databaseProperties.getUsername());
        comboPooledDataSource.setPassword(databaseProperties.getPassword());
        comboPooledDataSource.setMaxPoolSize(50);
        comboPooledDataSource.setMinPoolSize(2);
        comboPooledDataSource.setMaxIdleTime(60);
        return comboPooledDataSource;
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(ComboPooledDataSource comboPooledDataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(comboPooledDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }
}
