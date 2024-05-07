//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/queue/I{{class data.metadata.name type=true}}Subscriber.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.queue;

import com.kapeta.spring.rabbitmq.KapetaMessageListener;
import {{packageName options.basePackage}}.dto.*;

public interface I{{class data.metadata.name type=true}}Subscriber extends KapetaMessageListener<{{class data.spec.payloadType.type}}> {

}
