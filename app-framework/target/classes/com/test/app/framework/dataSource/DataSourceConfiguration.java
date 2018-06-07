package com.test.app.framework.dataSource;
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.app.framework.document.Swagger2Config;
import com.test.app.framework.document.Swagger2Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.beans.PropertyVetoException;
@Configuration
@ImportAutoConfiguration(classes = {Swagger2Config.class})
public class DataSourceConfiguration {
    @Value("${datasource.driver-class-name}")
    private /*static*/ String jdbcDriver;
    @Value("${datasource.url}")
    private /*static*/ String jdbcurl;
    @Value("${datasource.name}")
    private /*static*/ String jdbcUsernaem;
    @Value("${datasource.password}")
    private /*static*/ String jdbcPassword;
    /**
     * c3p0
     * @return
     */
    @Bean(name="dataSource")
    public /*static*/ ComboPooledDataSource createDataSource(/*Environment environment*/) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(/*environment.getProperty("datasource.driver-class-name")*/jdbcDriver);
        dataSource.setJdbcUrl(/*environment.getProperty("datasource.url")*/jdbcurl);
        dataSource.setUser(/*environment.getProperty("datasource.name")*/jdbcUsernaem);
        dataSource.setPassword(/*environment.getProperty("datasource.password")*/jdbcPassword);
        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
    /**
     * DriverManager
     * @return
     */
//    @Bean(name="dataSource")
//    public DriverManagerDataSource createDataSource(){
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName(jdbcDriver);
//        driverManagerDataSource.setUrl(jdbcurl);
//        driverManagerDataSource.setUsername(jdbcUsernaem);
//        driverManagerDataSource.setPassword(jdbcPassword);
//        return driverManagerDataSource;
//    }
}
