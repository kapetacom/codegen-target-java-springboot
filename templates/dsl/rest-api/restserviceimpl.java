{{#ai-context}}
//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/service/{{java-class-name this}}Service.java:create-only
{{ai-type 'service'}}
package {{packageName @root.options.basePackage}}.service;

import com.kapeta.spring.exceptions.IllegalArgumentException;
import com.kapeta.spring.exceptions.InvalidStateException;
import com.kapeta.spring.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
{{java-imports}}

{{java-controller-class this}}

{{else}}

//#FILENAME:src/main/java/{{packagePath @root.options.basePackage}}/service/{{java-class-name this}}Service.java:create-only
package {{packageName @root.options.basePackage}}.service;

import java.util.*;
import org.springframework.stereotype.Service;
{{java-imports}}

{{java-controller-class this}}
{{/ai-context}}
