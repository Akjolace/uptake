// package edu.mum.cs544.a4.configuration;

// import java.util.Locale;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.LocaleResolver;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
// import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
// import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// @Configuration
// @EnableWebMvc
// @ComponentScan(basePackages = { "edu.mum" })
// public class WebConfig extends WebMvcConfigurerAdapter {

//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler(
//             "/webjars/**", 
//             "/img/**", 
//             "/css/**", 
//             "/js/**").addResourceLocations(
//                 "classpath:/META-INF/resources/webjars/", "classpath:/static/img/", "classpath:/static/css/",
//                 "classpath:/static/js/");
//     }

    

// }