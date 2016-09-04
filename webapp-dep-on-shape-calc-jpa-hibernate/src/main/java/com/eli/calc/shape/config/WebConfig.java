package com.eli.calc.shape.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@Lazy
@ComponentScan(basePackages="com.eli.calc.shape")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		System.err.println("\n\n\n\nELI: Web Config\n\n\n\n");

		//index page mapping
		// "/" -> index.jsp
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/newreq").setViewName("newreq");
		registry.addViewController("/curreq").setViewName("curreq");
		registry.addViewController("/results").setViewName("results");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		System.err.println("\n\n\n\nELI: Web Config\n\n\n\n");

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}


	@Bean
	public InternalResourceViewResolver viewResolver() {//<--if i use this one (subclass), i dont get an error

		System.err.println("\n\n\n\nELI: Web Config\n\n\n\n");

		//UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
