//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/repositories/{{lowercase this.metadataName}}/{{class this.name type=true}}Repository.java:write-always
{{ai-type 'repository'}}

/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.repositories.usersdb;

import org.springframework.data.jpa.repository.JpaRepository;

{{#ai-comment}}
This is the repository class for the {{name}} entity. Use this from the services to access the database.
{{/ai-comment}}
public interface {{class this.name type=true}}Repository extends JpaRepository<{{class this.name type=true}}, String> {

}
