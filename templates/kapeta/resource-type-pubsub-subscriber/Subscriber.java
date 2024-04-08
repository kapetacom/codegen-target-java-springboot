//#FILENAME:src/main/java/{{packagePath options.basePackage}}/pubsub/{{data.spec.payloadType.type}}Subscriber.java:create-only
package {{packageName options.basePackage}}.pubsub;

import {{packageName options.basePackage}}.dto.{{data.spec.payloadType.type}}DTO;
import org.springframework.stereotype.Service;

@Service
public class {{data.spec.payloadType.type}}Subscriber implements I{{data.spec.payloadType.type}}Subscriber {
    @Override
    public void onMessage({{data.spec.payloadType.type}}DTO {{camelCase data.spec.payloadType.type}}DTO) throws Exception {
        throw new RuntimeException("Not implemented");
    }
}
