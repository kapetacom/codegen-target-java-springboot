/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.clients;

import com.blockware.spring.annotation.*;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

@BlockwareRestClient("users")
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
