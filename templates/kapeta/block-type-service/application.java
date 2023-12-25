//#FILENAME:src/main/java/{{packagePath options.basePackage}}/{{class data.metadata.name type=true}}Application.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}};

import com.kapeta.spring.KapetaApplication;

@EnableKapeta
public class {{class data.metadata.name type=true}}Application {

    public static void main(String[] args) {
        KapetaApplication.run({{class data.metadata.name type=true}}Application.class, args);
    }

}
