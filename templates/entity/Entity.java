//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/dto/{{type data.name}}.java
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.dto;

import lombok.*;
import java.util.*;

@Data
public class {{type data.name}} {

{{#eachProperty data.properties}}
    private {{type ./type}} {{variable propertyId}};
{{/eachProperty}}

}
