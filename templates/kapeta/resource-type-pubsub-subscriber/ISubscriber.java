//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/pubsub/I{{data.spec.payloadType.type}}Subscriber.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.pubsub;

import {{packageName options.basePackage}}.dto.{{data.spec.payloadType.type}}DTO;

public interface I{{data.spec.payloadType.type}}Subscriber {
    void onMessage({{data.spec.payloadType.type}}DTO {{camelCase data.spec.payloadType.type}}DTO) throws Exception;
}
