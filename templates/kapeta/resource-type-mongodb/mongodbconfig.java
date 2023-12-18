//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/repositories/{{data.metadata.name}}/{{class data.metadata.name type=true}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.repositories.{{data.metadata.name}};

import com.kapeta.spring.mongo.AbstractMongoDBConfig;
import com.kapeta.spring.mongo.repository.BaseMongoRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    repositoryBaseClass = BaseMongoRepositoryImpl.class,
    basePackages = { "{{string options.basePackage}}.repositories.{{string data.metadata.name}}" }
)

public class {{class data.metadata.name type=true}}Config extends AbstractMongoDBConfig {

    public {{class data.metadata.name type=true}}Config() {
        super("{{string data.metadata.name}}");
    }

}