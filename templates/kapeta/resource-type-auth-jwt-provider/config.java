//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/config/SecurityConfiguration.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain jwksFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/.well-known/jwks.json")
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/.well-known/jwks.json").permitAll()
                );
        return http.build();
    }
}
