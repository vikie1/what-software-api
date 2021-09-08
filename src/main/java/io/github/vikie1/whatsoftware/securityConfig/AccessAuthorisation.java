package io.github.vikie1.whatsoftware.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration @EnableWebSecurity
public class AccessAuthorisation extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers("/api/**");

        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/**", "/**").permitAll();

    }

    @Bean //disable CORS for '/api/**'
    public WebMvcConfigurer corsConfiguration(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
            }
        };
    }

}
