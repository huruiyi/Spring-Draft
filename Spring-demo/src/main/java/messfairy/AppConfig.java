package messfairy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan({"messfairy"})
@Import({DatabaseConfig.class, WebMvcConfig.class})
public class AppConfig {
    @Autowired
    private DatabaseConfig dataConfig;

    @Bean
    public DataSource blogSource() {
        return dataConfig.dataSource();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }

    @Bean
    public FormHttpMessageConverter formHttpMessageConverter() {
        return new FormHttpMessageConverter();
    }

    @Bean
    public RequestMappingHandlerAdapter mappingHandlerAdapter() {
        RequestMappingHandlerAdapter mappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(stringHttpMessageConverter());
        converters.add(formHttpMessageConverter());
        mappingHandlerAdapter.setMessageConverters(converters);
        return mappingHandlerAdapter;
    }
}
