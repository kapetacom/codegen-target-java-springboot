//#FILENAME:src/main/java/{{packagePath options.basePackage}}/config/BaseConfig.java:write-always
package {{packageName options.basePackage}}.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
{{#ai-context}}
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
{{/ai-context}}
{{#consumes 'kapeta/resource-type-postgresql'}}
import org.modelmapper.ModelMapper;
{{/consumes}}
/**
 * Base configurations
 * */
@Configuration
public class BaseConfig  {
    {{#ai-context}}
    @Bean
    protected BCryptPasswordEncoder getBCrypptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    {{/ai-context}}
    {{#consumes 'kapeta/resource-type-postgresql'}}
    @Bean
    protected ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    {{/consumes}}
}