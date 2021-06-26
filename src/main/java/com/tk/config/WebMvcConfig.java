package com.tk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.tk.*")
public class WebMvcConfig implements WebMvcConfigurer {
	
	// get resource from src/main
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        //registry.addViewController("/").setViewName("home");
    }
	
	   @Bean
	   public ViewResolver viewResolver() {
	      InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    //  bean.setViewClass(JstlView.class);
	      bean.setPrefix("/WEB-INF/views/");
	      bean.setSuffix(".jsp");
	      return bean;
	   }
	 
		@Bean
	    public StandardServletMultipartResolver getMultipartResolver() {
	    	return new StandardServletMultipartResolver();
	    }
		
	  @Bean
	    public ReloadableResourceBundleMessageSource messageSource(){
	        ReloadableResourceBundleMessageSource bundleMessageSource=new ReloadableResourceBundleMessageSource();
	        bundleMessageSource.setBasenames(new String[] {"/WEB-INF/i18n/messages","resources/messages/validator"});
	        bundleMessageSource.setDefaultEncoding("UTF-8");
	        bundleMessageSource.setUseCodeAsDefaultMessage(true);
	        return bundleMessageSource;
	    }
	
}
