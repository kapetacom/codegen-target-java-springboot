//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/dto/{{class data.name type=true}}{{#when data.type type='dto'}}Base.java:write-always||.java:write-always{{/when}}
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.dto;

import lombok.*;
import java.util.*;

{{#eachTypeReference data}}
import {{../options.basePackage}}.dto.{{class name}};
{{/eachTypeReference}}

{{#switch data.type}}
{{#case 'dto'}}
@Data
public class {{class data.name type=true}}Base {

        {{#eachProperty data.properties}}
private {{classFrom this}} {{variable propertyId}};
        {{/eachProperty}}

}
{{/case}}
{{#case 'enum'}}
enum {{class data.name}} {
{{enumValues data.values}}
}
{{/case}}
{{/switch}}
