//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/queue/{{class data.metadata.name type=true}}PublisherConfig.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.queue;

import com.kapeta.spring.rabbitmq.RabbitConnectionManager;
import com.kapeta.spring.rabbitmq.RabbitMQProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class {{class data.metadata.name type=true}}PublisherConfig {

    @Bean
    public static RabbitMQProvider {{camelCase data.metadata.name}}Provider(RabbitConnectionManager rabbitConnectionManager) {
        return new RabbitMQProvider(rabbitConnectionManager, "{{string data.metadata.name}}");
    }

}
