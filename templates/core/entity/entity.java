//#FILENAME:src/main/java/{{packagePath options.basePackage}}/dto/{{class data.name}}.java:{{#when data.type type='dto'}}create-only||skip{{/when}}
package {{packageName options.basePackage}}.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class {{class data.name}} extends {{class data.name type=true}}Base {

}
