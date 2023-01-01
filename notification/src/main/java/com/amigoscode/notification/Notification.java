package com.amigoscode.notification;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class Notification {

  @Id
  @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
  Integer notificationId;

  Integer toCustomerId;

  String toCustomerEmail;

  String sender;

  String message;

  LocalDateTime sentAt;

}
