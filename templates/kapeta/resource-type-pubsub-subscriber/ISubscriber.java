//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/pubsub/I{{pascalCase data.metadata.name}}Subscriber.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.pubsub;

import {{packageName options.basePackage}}.dto.*;

public interface I{{pascalCase data.metadata.name}}Subscriber {
    void onMessage({{class data.spec.payloadType.type}} event) throws Exception;
}
