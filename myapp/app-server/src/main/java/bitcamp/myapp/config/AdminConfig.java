package bitcamp.myapp.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.sql.DataSource;

// Application을 실행하는데 필요한 객체를 설정하는 일을 한다.
//
@ComponentScan(
        basePackages = "bitcamp.myapp.controller",
        excludeFilters =  {
                @ComponentScan.Filter (type = FilterType.REGEX, pattern = ".*BoardController"),
                @ComponentScan.Filter (type = FilterType.REGEX, pattern = ".*HomeController"),
                @ComponentScan.Filter (type = FilterType.REGEX, pattern = ".*AuthController")
        }
)

public class AdminConfig {

  public AdminConfig() { System.out.println("AdminConfig() 호출됨!");}

  @Bean
  public MultipartResolver multipartResolver() { return new StandardServletMultipartResolver();}

}
