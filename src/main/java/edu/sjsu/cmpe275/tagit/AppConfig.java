package edu.sjsu.cmpe275.tagit;


import edu.sjsu.cmpe275.tagit.AOP.AOP;
import edu.sjsu.cmpe275.tagit.Utils.EmailNotification;
import edu.sjsu.cmpe275.tagit.interceptor.LoginInterceptor;
import edu.sjsu.cmpe275.tagit.services.Share.ShareService;
import edu.sjsu.cmpe275.tagit.services.Share.ShareServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by mjain on 11/23/15.
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = "edu.sjsu.cmpe275.tagit")
@Configuration
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public AOP getTagitLogin(){
        return new AOP();
    }

    @Bean
    public EmailNotification getEmailNotification(){
        return new EmailNotification();
    }

    @Bean
    public ShareService getShareService(){
        return new ShareServiceImpl();
    }

    @Bean
    public LoginInterceptor loginInterceptor()
    {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor= loginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/tag/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/notebook/getAll/user/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/notebook/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/notebook/getShared/user/*");

        registry.addInterceptor(loginInterceptor).addPathPatterns("/bookmark/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/bookmark/getAll/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/bookmark/getCount/notebook/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/bookmark/user/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/bookmark/getCount/user/*");

        registry.addInterceptor(loginInterceptor).addPathPatterns("/comment/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/comment/getAll/*");

        registry.addInterceptor(loginInterceptor).addPathPatterns("/share/*");

        registry.addInterceptor(loginInterceptor).addPathPatterns("/tag/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/tag/getAll/user/*");
    }

}
