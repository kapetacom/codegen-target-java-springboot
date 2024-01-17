//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/service/{{java-class-name this}}Service.java:create-only
package {{packageName @root.options.basePackage}}.service;

import java.util.*;
import org.springframework.stereotype.Service;
{{#anyEntities}}
import {{@root.options.basePackage}}.dto.*;
{{/anyEntities}}

{{java-controller-class this}}
