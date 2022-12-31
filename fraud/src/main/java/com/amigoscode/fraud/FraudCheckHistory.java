package com.amigoscode.fraud;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FraudCheckHistory {

  @Id
  @SequenceGenerator(
          name = "fraud_id_sequence",
          sequenceName = "fraud_id_sequence"
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "fraud_id_sequence"
  )
  Integer id;

  Integer customerId;

  Boolean isFraudster;

  LocalDateTime createdAt;

}
