//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/dto/{{java-class-name this}}DTO.java:{{#when type type='datatype'}}create-only||skip{{/when}}
{{ai-type 'dto'}}
package {{packageName @root.options.basePackage}}.dto;

import lombok.*;
{{#ai-context}}
Use this file whenever referring to the {{name}} type.
{{/ai-context}}
@Data
@EqualsAndHashCode(callSuper = true)
public class {{java-class-name this}}DTO{{java-generics this}} extends {{class name type=true}}Base{{java-generics this}} {

}
