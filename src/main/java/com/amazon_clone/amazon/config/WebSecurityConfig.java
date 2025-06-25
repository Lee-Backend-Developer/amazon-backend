package com.amazon_clone.amazon.config;

import com.amazon_clone.amazon.member.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final MemberDetailService memberDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);

        http.formLogin(formLogin ->
                formLogin.loginPage("/api/member/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successForwardUrl("/")
        );

        http.authorizeHttpRequests(
                authorize ->
                authorize
                        // 게스트 유저가 접근할 수 있는 URL
                        .requestMatchers("/api/member/login", "/api/member/register")
                        .permitAll()
                        .anyRequest().authenticated()
        );

        http.logout(logout -> logout.logoutUrl("/api/member/logout"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoOpPasswordEncoder();
    }

   /* @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(memberDetailService)
                .and().build();


    }*/


}
