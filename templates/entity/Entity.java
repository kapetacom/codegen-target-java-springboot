//#FILENAME:src/main/java/{{packagePath options.basePackage}}/dto/{{type data.name}}.java:create-only
package {{options.basePackage}}.dto;

import lombok.*;
import java.util.*;

import {{options.basePackage}}.gen.dto.{{type data.name}}Base

@Data
public class {{class data.name}} extends {{type data.name}}Base {

}
