//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/dto/{{java-class-name this}}{{#when type type='datatype'}}Base.java:write-always||.java:write-always{{/when}}
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.dto;

import lombok.*;
import java.util.*;
import jakarta.validation.constraints.NotNull;

{{#switch type}}
{{#case 'datatype'}}
{{java-type-dto this}}
{{/case}}
{{#case 'enum'}}
{{java-type-dto this}}
{{/case}}
{{/switch}}
