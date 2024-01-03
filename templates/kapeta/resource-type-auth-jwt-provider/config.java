//#FILENAME:src/main/java/{{packagePath options.basePackage}}/config/SecurityConfiguration.java:create-only
package {{options.basePackage}}.config;

import com.kapeta.spring.config.JWKInternalKeyStore;
import com.kapeta.spring.config.JWKInternalKeyStoreProvider;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.UUID;

@Configuration
public class SecurityConfiguration {

    @Bean
    public JWKInternalKeyStoreProvider jwkPublicKeySetProvider() {
        return () -> new JWKInternalKeyStore("https://auth.kapeta.com", null, getKeyStore());
    }

    private JWKSet getKeyStore() {
        String fileName = "jwks.json";
        return new File(fileName).exists() ? readJWKS(fileName) : createAndWriteJWKS(fileName);
    }

    private JWKSet readJWKS(String fileName) {
        try {
            return JWKSet.parse(Files.readString(Paths.get(fileName)));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private JWKSet createAndWriteJWKS(String fileName) {
        JWKSet jwks = createJWKS();
        writeJWKS(fileName, jwks);
        return jwks;
    }

    private JWKSet createJWKS() {
        try {
            return new JWKSet(new RSAKeyGenerator(2048)
                    .keyUse(KeyUse.SIGNATURE)
                    .keyID(UUID.randomUUID().toString())
                    .generate());
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeJWKS(String fileName, JWKSet jwkSet) {
        try {
            Files.writeString(Paths.get(fileName), jwkSet.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
