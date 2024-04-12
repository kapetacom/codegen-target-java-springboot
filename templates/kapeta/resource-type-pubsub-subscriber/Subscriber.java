//#FILENAME:src/main/java/{{packagePath options.basePackage}}/pubsub/{{pascalCase data.metadata.name}}Subscriber.java:create-only
package {{packageName options.basePackage}}.pubsub;

import {{packageName options.basePackage}}.dto.{{data.spec.payloadType.type}}DTO;
import org.springframework.stereotype.Service;

@Service
public class {{pascalCase data.metadata.name}}Subscriber implements I{{pascalCase data.metadata.name}}Subscriber {
    @Override
    public void onMessage({{data.spec.payloadType.type}}DTO {{camelCase data.spec.payloadType.type}}DTO) throws Exception {
        throw new RuntimeException("Not implemented");
    }
}
