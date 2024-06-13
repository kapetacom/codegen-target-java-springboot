//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/dto/{{java-class-name this}}DTO.java:{{#when type type='datatype'}}create-only||skip{{/when}}
{{ai-type 'dto'}}
package {{packageName @root.options.basePackage}}.dto;

import lombok.*;
{{#ai-comment}}
Use this file whenever referring to the {{name}} type.

To instantiate this class always use the zero-argument constructor and set the properties using the setter methods.
For example, to instantiate the {{name}}DTO class, use the following code snippet:
```java
var dto = new {{java-class-name this}}DTO();
```
{{/ai-comment}}
@Data
@EqualsAndHashCode(callSuper = true)
public class {{java-class-name this}}DTO{{java-generics this}} extends {{class name type=true}}Base{{java-generics this}} {

}
