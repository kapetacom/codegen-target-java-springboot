//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/repositories/{{lowercase this.metadataName}}/{{class this.name type=true}}.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.repositories.usersdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class {{class this.name type=true}} {

    {{#each properties}}
        {{#if this.primary}}
            @Id
            @GeneratedValue(generator = "UUID")
            @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
            @Column(name = "{{this.name}}", updatable = false, nullable = false)
        {{else}}
            {{#if this.optional}}
                @Column(name = "{{this.name}}")
            {{else}}
                @Column(name = "{{this.name}}", nullable = false)
            {{/if}}
        {{/if}}
        {{kaplang-model-type-declaration this}}
    {{/each}}
}
