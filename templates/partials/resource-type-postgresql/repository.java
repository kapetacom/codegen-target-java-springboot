//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/repositories/{{lowercase this.metadataName}}/{{class this.name type=true}}Repository.java:write-always

/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.repositories.usersdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface {{class this.name type=true}}Repository extends JpaRepository<{{class this.name type=true}}, String> {

}
