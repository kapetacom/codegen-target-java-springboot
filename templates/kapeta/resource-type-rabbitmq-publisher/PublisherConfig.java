//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/queue/{{class data.metadata.name type=true}}PublisherConfig.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.queue;

import com.kapeta.spring.rabbitmq.RabbitConnectionManager;
import com.kapeta.spring.rabbitmq.RabbitMQProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import {{packageName options.basePackage}}.dto.*;

@Configuration
public class {{class data.metadata.name type=true}}PublisherConfig {

    @Bean
    public static RabbitMQProvider<{{class data.spec.payloadType.type}}> {{camelCase data.metadata.name}}Provider(RabbitConnectionManager rabbitConnectionManager) {
        return new RabbitMQProvider<>(rabbitConnectionManager, "{{string data.metadata.name}}", {{class data.spec.payloadType.type}}.class);
    }

}
