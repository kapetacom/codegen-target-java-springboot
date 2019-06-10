//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/dto/{{type data.name}}.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.dto;

import lombok.*;
import java.util.*;
import javax.persistence.*;

@Data
public class {{type data.name}}Base {

{{#eachProperty data.properties}}
    private {{type ./type}} {{variable propertyId}};
{{/eachProperty}}

}
