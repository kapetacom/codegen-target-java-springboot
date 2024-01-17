//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/service/I{{java-class-name this}}Service.java:create-only
package {{packageName @root.options.basePackage}}.service;

import java.util.*;
{{#anyEntities}}
import {{@root.options.basePackage}}.dto.*;
{{/anyEntities}}

{{java-controller-if this}}
