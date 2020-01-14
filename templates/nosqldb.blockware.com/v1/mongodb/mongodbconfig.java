//#FILENAME:src/main/java/{{packagePath options.basePackage}}/repositories/{{data.metadata.name}}/{{type data.metadata.name}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.repositories.{{data.metadata.name}};

import com.blockware.spring.mongo.AbstractMongoDBConfig;
import com.blockware.spring.mongo.repository.BaseMongoRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    repositoryBaseClass = BaseMongoRepositoryImpl.class,
    basePackages = { "{{string options.basePackage}}.repositories.{{string data.metadata.name}}" }
)
public class {{type data.metadata.name}}Config extends AbstractMongoDBConfig {

    public {{type data.metadata.name}}Config() {
        super("{{string data.metadata.name}}");
    }

}