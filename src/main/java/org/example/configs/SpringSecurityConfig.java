package org.example.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception{

        http.csrf();
        http.httpBasic().disable();
        http.rememberMe();

        http.authorizeHttpRequests()
                .requestMatchers("/", "/home", "/signup").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/signin")
                .defaultSuccessUrl("/")
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

        return http.build();
    }
}
