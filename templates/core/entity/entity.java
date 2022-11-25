//#FILENAME:src/main/java/{{packagePath options.basePackage}}/dto/{{class data.name}}.java:{{#when data.type type='dto'}}create-only||skip{{/when}}
package {{options.basePackage}}.dto;

import lombok.*;
import java.util.*;

import {{options.basePackage}}.gen.dto.{{type data.name}}Base;

@Data
public class {{class data.name}} extends {{class data.name type=true}}Base {

}
