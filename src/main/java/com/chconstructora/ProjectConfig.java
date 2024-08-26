
package com.chconstructora;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 @author rebecahurtado
 */

@Configuration
public class ProjectConfig implements  WebMvcConfigurer{
    /*Los siguientes metodos son para incorporar el tema de internacionalizacio en el proyexto*/
    
    /*LocaleResolver se usa para crear una session de cambio de idioma*/
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }
   /* LocaleChangeInterceptor se usa para crear un interceptor de cambio de idioma*/
    @Bean
     public LocaleChangeInterceptor localeChangeInterceptor(){
         var lci = new LocaleChangeInterceptor();
         lci.setParamName("lang");
         
         return lci;
     }
     
    
     @Override
     public void addInterceptors(InterceptorRegistry registro){
         
         registro.addInterceptor(localeChangeInterceptor());
     }
     
     @Bean("messageSource")
     public MessageSource messageSource(){
         ResourceBundleMessageSource messageSource = new  ResourceBundleMessageSource();
         messageSource.setBasenames("messages");
         messageSource.setDefaultEncoding("UTF-8");
         return messageSource;
         
     }
     @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
    
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("rebeca")
                .password("{noop}123")
                .roles("USER","VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
                .username("manuel")
                .password("{noop}456")
                .roles("VENDEDOR","USER")
                .build();
        UserDetails user = User.builder()
                .username("gladys")
                .password("{noop}789")
                .roles("USER")
                .build();
        UserDetails usuario = User.builder()
                .username("rhurtado50476")
                .password("{noop}789")
                .roles("USUARIO")
                .build();
        
        return new InMemoryUserDetailsManager(user,sales, admin,usuario);
    }
    
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/",
                        "/index",                        
                        "/inicio/**",
                        "/acerca/**",
                         "/proyecto/proyectos",
                         "/proyecto/acabados",
                         "/contacto/**",
                        "/webjars/**",
                        "/css/**",
                        "/js/**",
                        "/img/**"
                        ).permitAll()
                .requestMatchers(
                        "/proyecto/nuevo",        
                        "/proyecto/guardar", 
                             "/proyecto/modificar/**", 
                             "/proyecto/eliminar/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/proyecto/listado"
                ).hasAnyRole("ADMIN", "VENDEDOR"))
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
    
    


}
