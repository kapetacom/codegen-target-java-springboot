//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/dto/{{java-class-name this}}{{#when type type='datatype'}}Base.java:write-always||.java:write-always{{/when}}
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.dto;

import lombok.*;
import java.util.*;
import jakarta.validation.constraints.NotNull;
{{java-imports}}

{{#switch type}}
{{#case 'datatype'}}
{{#ai-context}}
This is the base class for the {{name}} type. It should not be used directly.
{{/ai-context}}
{{java-type-dto this}}
{{/case}}
{{#case 'enum'}}
{{#ai-context}}
Refer to this file whenever you need to use the enum type {{name}}.
{{/ai-context}}
{{java-type-dto this}}
{{/case}}
{{/switch}}
