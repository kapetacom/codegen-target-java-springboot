//#FILENAME:src/main/java/{{packagePath options.basePackage}}/config/BaseConfig.java:write-always
package {{packageName options.basePackage}}.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
{{#ai-context}}
{{#provides 'kapeta/resource-type-auth-jwt-provider'}}
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
{{/provides}}
{{#provides 'kapeta/resource-type-rest-api'}}
import org.modelmapper.ModelMapper;
{{/provides}}
{{/ai-context}}
/**
 * Base configurations
 * */
@Configuration
public class BaseConfig  {
    {{#ai-context}}
    {{#provides 'kapeta/resource-type-auth-jwt-provider'}}
    @Bean
    protected BCryptPasswordEncoder getBCrypptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    {{/provides}}
    {{#provides 'kapeta/resource-type-rest-api'}}
    @Bean
    protected ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    {{/provides}}
    {{/ai-context}}
}