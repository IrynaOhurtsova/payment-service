package org.bus.ticket.payment.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder(toBuilder = true)
public class Payment {

    @Id
    long id;
    String lastName;
    String firstName;
    String patronymic;
    double sum;
    PaymentStatus paymentStatus;
}
