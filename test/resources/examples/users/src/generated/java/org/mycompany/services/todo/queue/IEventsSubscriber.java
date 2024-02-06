/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import com.kapeta.spring.rabbitmq.KapetaMessageListener;
import org.mycompany.services.todo.dto.User;

public interface IEventsSubscriber extends KapetaMessageListener<User> {}
