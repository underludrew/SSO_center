package only.yyq.SSOCenter;

import only.yyq.SSOCenter.Utils.Interceptor.loginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@Configuration
//@EnableWebMvc
@MapperScan(basePackages = "only.yyq.SSOCenter.Mappers")
public class App  extends WebMvcConfigurerAdapter
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(new loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/static/js/**","/static/css/**","/admin","/static/img/**","/image/**","/static/**");
    }
}
