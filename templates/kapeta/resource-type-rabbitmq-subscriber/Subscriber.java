//#FILENAME:src/main/java/{{packagePath options.basePackage}}/queue/{{class data.metadata.name type=true}}Subscriber.java:write-always
{{ai-type 'event-subscriber'}}
package {{packageName options.basePackage}}.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import {{packageName options.basePackage}}.dto.*;

{{#ai-comment}}
This is the subscriber for the {{data.metadata.name}} consumer.
{{/ai-comment}}

@Slf4j
@Component
public class {{class data.metadata.name type=true}}Subscriber implements I{{class data.metadata.name type=true}}Subscriber {

    @Override
    public void onMessage(Message<{{class data.spec.payloadType.type}}> message) {
        {{#ai-comment}}
        Implement this method to handle messages from the {{data.metadata.name}} consumer.
        {{/ai-comment}}
        log.warn("Received message from {{string data.metadata.name}} using example handler: {}", message);
    }

}
