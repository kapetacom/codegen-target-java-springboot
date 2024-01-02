/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.rest;

import com.kapeta.spring.annotation.*;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.service.IJwksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@KapetaController("jwks")
public class JwksController {

    private final IJwksService service;

    @Autowired
    public JwksController(IJwksService service) {
        this.service = service;
    }

    /**
     *
     */
    @ResponseBody
    @RequestMapping(
        value = "/.well-known/jwks.json",
        method = RequestMethod.GET
    )
    public Map<String, Object> getJWKS() throws Exception {
        return service.getJWKS();
    }
}
