//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/dto/{{class data.name type=true}}{{#when data.type type='dto'}}Base.java:write-always||.java:write-always{{/when}}
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.dto;

import lombok.*;
import java.util.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
{{#eachTypeReference data}}
import {{../options.basePackage}}.dto.{{class name}};
{{/eachTypeReference}}

{{#switch data.type}}
{{#case 'dto'}}
@Data
public class {{class data.name type=true}}Base {

        {{#eachProperty data.properties}}
                {{#if optional}}@Nullable{{else}}@NonNull{{/if}}
                private {{classFrom this}} {{variable propertyId}};
        {{/eachProperty}}

}
{{/case}}
{{#case 'enum'}}
public enum {{class data.name}} {
{{enumValues data.values}}
}
{{/case}}
{{/switch}}
