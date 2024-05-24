//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/clients/{{pascalCase data.metadata.name}}Bucket.java:write-always
{{ai-type 'client'}}
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.clients;

import com.kapeta.spring.cloudbucket.CloudBucketClientFactory;
import org.springframework.stereotype.Component;

{{#ai-context}}
This is the client for the {{pascalCase data.metadata.name}} bucket.
Use this client to interact with the {{pascalCase data.metadata.name}} bucket.
{{/ai-context}}
@Component
public class {{pascalCase data.metadata.name}}Bucket extends CloudBucketClientFactory.Client {

    public {{pascalCase data.metadata.name}}Bucket(CloudBucketClientFactory factory) throws Exception {
        super(factory, "{{string data.metadata.name}}", "{{kebab data.metadata.name}}");
    }

}