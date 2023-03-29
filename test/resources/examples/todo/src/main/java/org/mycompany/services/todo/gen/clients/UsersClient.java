/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.clients;

import org.mycompany.services.todo.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

@KapetaRestClient("users")
public interface UsersClient {
    /**
     * undefined
     */
    @DELETE("users/{other}")
    Call<Void> deleteUser(@Path("other") String other);

    /**
     * undefined
     */
    @GET("users/{other}/test")
    Call<UserDTO> getUser(@Path("other") String other);
}
