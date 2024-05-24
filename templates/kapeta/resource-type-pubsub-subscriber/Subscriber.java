//#FILENAME:src/main/java/{{packagePath options.basePackage}}/pubsub/{{pascalCase data.metadata.name}}Subscriber.java:create-only
{{ai-type 'event-subscriber'}}
package {{packageName options.basePackage}}.pubsub;

import {{packageName options.basePackage}}.dto.*;
import org.springframework.stereotype.Service;

{{#ai-context}}
This is the subscriber for the {{data.metadata.name}} consumer.
{{/ai-context}}

@Service
public class {{pascalCase data.metadata.name}}Subscriber implements I{{pascalCase data.metadata.name}}Subscriber {
    @Override
    public void onMessage({{class data.spec.payloadType.type}} event) throws Exception {
        {{#ai-context}}
        Implement this method to handle messages from the {{data.metadata.name}} consumer.
        {{/ai-context}}
        throw new RuntimeException("Not implemented");
    }
}
