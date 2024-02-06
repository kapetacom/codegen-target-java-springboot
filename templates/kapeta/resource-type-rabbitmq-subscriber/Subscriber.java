//#FILENAME:src/main/java/{{packagePath options.basePackage}}/queue/{{class data.metadata.name type=true}}Subscriber.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import {{packageName options.basePackage}}.dto.{{class data.spec.payloadType.type}};

@Slf4j
@Component
public class {{class data.metadata.name type=true}}Subscriber implements I{{class data.metadata.name type=true}}Subscriber {

    @Override
    public void onMessage(Message<{{class data.spec.payloadType.type}}> message) {
        log.warn("Received message from {{string data.metadata.name}} using example handler: {}", message);
    }

}
