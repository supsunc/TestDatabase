package cn.ssc.example.testdatabase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:config/db.properties"})
public class DatabaseProperties {
    @Value(value = "${jdbc.driver}")
    private  String driver;
    @Value(value = "${jdbc.url}")
    private  String url;
    @Value(value = "${jdbc.username}")
    private  String username;
    @Value(value = "${jdbc.password}")
    private  String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
