/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.clients;

import com.kapeta.spring.annotation.KapetaRestClient;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

@KapetaRestClient("users")
public interface UsersClient {
    /**
     *
     */
    @DELETE("users/{other}")
    Call<Void> deleteUser(
        @Path("other") String other,
        @Header("Kapeta-Overwrite") String overwrite
    );

    /**
     *
     */
    @GET("users/{other}/test")
    Call<UserDTO> getUser(
        @Path("other") String other,
        @HeaderMap Map<String, String> metadata
    );
}
