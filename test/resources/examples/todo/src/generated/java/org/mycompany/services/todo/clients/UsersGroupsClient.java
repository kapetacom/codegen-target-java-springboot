/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.clients;

import com.kapeta.spring.annotation.KapetaRestClient;
import java.util.*;
import retrofit2.Call;
import retrofit2.http.*;

@KapetaRestClient("users")
public interface UsersGroupsClient {
    /**
     * Create group
     */
    @POST("groups/{groupId}")
    Call<Void> addGroup(@Path("groupId") String groupId);

    /**
     * Delete group
     */
    @DELETE("groups/{groupId}")
    Call<Void> deleteGroup(@Path("groupId") String groupId);
}
