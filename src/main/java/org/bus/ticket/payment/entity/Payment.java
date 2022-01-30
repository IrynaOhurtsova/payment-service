package org.bus.ticket.payment.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder(toBuilder = true)
public class Payment {

    @Id
    private long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private double sum;
    private PaymentStatus paymentStatus;
}
