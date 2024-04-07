package ntnu.fullstacksuperteam.backend.security;

import ntnu.fullstacksuperteam.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;


/**
 * Configuration class for Spring Security.
 * Enables web security and configures the application's security settings, including CORS, CSRF,
 * session management, and the registration of custom security filters. This configuration is
 * essential for securing the application's endpoints and ensuring that only authenticated users
 * can access certain resources.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    private TokenService tokenService;

  /**
   * Defines the password encoder bean to use for encoding passwords.
   * Utilizes {@link BCryptPasswordEncoder} for hashing passwords securely.
   *
   * @return the password encoder
   */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
  /**
   * Configures the {@link HttpSecurity} object to specify the web security configuration,
   * applying various security settings such as CORS, CSRF, session management, and custom
   * security filters.
   *
   * @param http the {@link HttpSecurity} to configure
   * @return the configured {@link SecurityFilterChain}
   * @throws Exception if an error occurs during configuration
   */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Allow your frontend origin
                    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
                    return config;
                })) // Configure CORS as needed, if at all
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/login", "/auth/register", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // Allow access to /token without authentication
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
                )
                .addFilterBefore(new JWTAuthorizationFilter(tokenService), UsernamePasswordAuthenticationFilter.class); // Register your custom filter

        return http.build();
    }
}
