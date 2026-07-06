package com.example.tiendaonline.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Todos pueden consultar Clientes y Productos
                        .requestMatchers(HttpMethod.GET, "/clientes/", "/productos/").permitAll()
                        // Solo Admin pueden crear un Cliente y/o Producto
                        .requestMatchers(HttpMethod.POST, "/cplientes/", "/productos/").hasRole("ADMIN")
                        // Solo Admin puede modificar un Cliente y/o Producto
                        .requestMatchers(HttpMethod.PUT, "/clientes/**", "/productos/**").hasRole("CLIENT")
                        // Cualquier otra ruta
                        .anyRequest().authenticated())
                .httpBasic(httpBasic -> {});

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin123"));
        System.out.println(encoder.encode("cliente123"));
        return encoder;
    }


}
