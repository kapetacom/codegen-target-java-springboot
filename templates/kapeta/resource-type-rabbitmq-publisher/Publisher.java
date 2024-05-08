//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/queue/{{class data.metadata.name type=true}}Publisher.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.queue;

import com.kapeta.spring.rabbitmq.RabbitMQProvider;
import com.kapeta.spring.rabbitmq.RabbitPublisher;
import org.springframework.stereotype.Component;
import {{packageName options.basePackage}}.dto.*;

@Component
public class {{class data.metadata.name type=true}}Publisher extends RabbitPublisher<{{class data.spec.payloadType.type}}> {

    public {{class data.metadata.name type=true}}Publisher(RabbitMQProvider<{{class data.spec.payloadType.type}}> {{camelCase data.metadata.name}}Provider) {
        super({{camelCase data.metadata.name}}Provider.getTemplate(), {{camelCase data.metadata.name}}Provider.getTargetedExchangeNames());
    }

}