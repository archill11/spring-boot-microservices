package com.amigoscode.customer;

import com.amigoscode.amqp.RabbitMQMessageProducer;
import com.amigoscode.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final RabbitMQMessageProducer rabbitMQMessageProducer;

//────────────────────────────────────────────────────────────────────────────────────────

  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = Customer.builder()
                                .firstName(request.firstName())
                                .lastName(request.lastName())
                                .email(request.email())
                                .build();

    customerRepository.save(customer);

    NotificationRequest notificationRequest = new NotificationRequest(
            customer.getId(),
            customer.getEmail(),
            String.format("Hi %s, welcome to Amigoscode...", customer.getFirstName())
    );

    rabbitMQMessageProducer.publish(
            notificationRequest,
            "internal.exchange",
            "internal.notification.routing-key"
    );
  }

//────────────────────────────────────────────────────────────────────────────────────────


}
