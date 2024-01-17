//#FILENAME:src/generated/java/{{packagePath @root.options.basePackage}}/rest/{{java-class-name this}}Controller.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName @root.options.basePackage}}.rest;

import {{packageName @root.options.basePackage}}.service.I{{java-class-name this}}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;
import com.kapeta.spring.annotation.*;
import java.util.*;
import jakarta.validation.Valid;
{{#anyEntities}}
import {{@root.options.basePackage}}.dto.*;
{{/anyEntities}}

{{java-controller-rest this}}