package com.amigoscode.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

  @Id
  @SequenceGenerator(
          name = "customer_id_sequence",
          sequenceName = "customer_id_sequence"
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "customer_id_sequence"
  )
  Integer id;
  String firstName;
  String lastName;
  String email;
//────────────────────────────────────────────────────────────────────────────────────────
}
