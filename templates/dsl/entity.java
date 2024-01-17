//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/dto/{{java-class-name this}}DTO.java:{{#when type type='datatype'}}create-only||skip{{/when}}
package {{packageName @root.options.basePackage}}.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class {{class name}}DTO{{java-generics this}} extends {{class name type=true}}Base{{java-generics this}} {

}
