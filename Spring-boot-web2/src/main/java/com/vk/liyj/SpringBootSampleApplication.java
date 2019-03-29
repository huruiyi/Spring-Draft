package com.vk.liyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vk.liyj.dynamicDataSource.DynamicDataSourceRegister;
import com.vk.liyj.servlet.LiyjServlet;
/**
 * @Description springboot启动器
 * @ClassName SpringBootTest
 * @author liyj23
 */

/**
 *
 @SpringBootApplication 相当于@Configuration,@EnableAutoConfiguration,@ComponentScan
 */
@SpringBootApplication(scanBasePackages = {"com.vk.liyj"}, exclude = {})
//扫描工程中的Servlet、Filter、Listener
@ServletComponentScan(basePackages = {"com.vk.liyj"})
//mybatis框架中的dao扫描
@MapperScan("com.vk.liyj.**.mapper")
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
//启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
public class SpringBootSampleApplication {
    /**
     * 这里是通过代码的形式注册一个Servlet，这种形式不需要@ServletComponentScan注解
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new LiyjServlet(), "/hello/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
