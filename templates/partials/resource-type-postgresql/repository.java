//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/repositories/{{lowercase this.metadataName}}/{{class this.name type=true}}Repository.java:create-only
{{ai-type 'repository'}}

package {{packageName @root.options.basePackage}}.repositories.{{lowercase this.metadataName}};

import org.springframework.data.jpa.repository.JpaRepository;

{{#ai-comment}}
This is the repository class for the {{name}} entity. Use this from the services to access the database.
{{/ai-comment}}
public interface {{class this.name type=true}}Repository extends JpaRepository<{{class this.name type=true}}, String> {

}
