//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/clients/{{class name type=true}}Client.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.clients;

import com.kapeta.spring.annotation.KapetaRestClient;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.*;
{{#anyEntities}}
    import {{@root.options.basePackage}}.dto.*;
{{/anyEntities}}


{{java-controller-client this}}