//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/service/I{{java-class-name this}}Service.java:create-only
{{ai-type 'service-interface'}}
package {{packageName @root.options.basePackage}}.service;

import java.util.*;
{{java-imports}}

{{#ai-context}}
    This is the service interface for the {{java-class-name this}} service.
{{/ai-context}}
{{java-controller-if this}}
