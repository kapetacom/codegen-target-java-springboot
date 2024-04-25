//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/BaseConfig.java:write-once
package {{packageName options.basePackage}}.config;

import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.annotation.KapetaTestContext;

/**
 * Base configurations for the test environment
 *
 * You can add beans or similar here if needed.
 *
 * @KapetaTestContext will provide the Kapeta SDK with the necessary information to configure the test environment
 *
 * Also see the {{packageName options.basePackage}}.config package for more test configuration
 */
@Configuration
@KapetaTestContext
public class BaseConfig  {

}