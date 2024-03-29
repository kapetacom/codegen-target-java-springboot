/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.clients;

import com.kapeta.spring.annotation.KapetaRestClient;
import java.util.*;
import org.mycompany.services.todo.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.*;

@KapetaRestClient("users")
public interface UsersClient {
    @DELETE("users/{other}")
    Call<Void> deleteUser(
        @Path("other") String other,
        @Header("Kapeta-Overwrite") String overwrite
    );

    @GET("users/{other}/test")
    Call<UserDTO> getUser(
        @Path("other") String other,
        @HeaderMap Map<String, UserDTO> metadata
    );

    /**
     * Get all users
     */
    @GET("users")
    Call<List<UserDTO>> listUsers(@Query("filter") Set<String> filter);
}
