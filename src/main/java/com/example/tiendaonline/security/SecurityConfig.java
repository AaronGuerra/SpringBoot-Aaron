package com.example.tiendaonline.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(auth -> auth
                        // Todos pueden consultar Clientes y Productos
                        .requestMatchers(HttpMethod.GET, "/clientes/**", "/productos/**").permitAll()
                        // Todos pueden crear un Cliente y/o Producto
                        .requestMatchers(HttpMethod.POST, "/clientes/**", "/productos/**").permitAll()
                        // Solo Cliente puede modificar un Cliente y/o Producto
                        .requestMatchers(HttpMethod.PUT, "/clientes/**", "/productos/**").hasRole("CLIENT")
                        // Solo Admin puede eliminar un cliente y/o producto
                        .requestMatchers(HttpMethod.DELETE, "/clientes/**", "/productos/**").hasRole("ADMIN")
                        // Todos pueden logearse
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        // Cualquier otra ruta
                        .anyRequest().authenticated())
                .httpBasic(httpBasic -> {});

        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(ClienteDetailsService clienteDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(clienteDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config){
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }



}
