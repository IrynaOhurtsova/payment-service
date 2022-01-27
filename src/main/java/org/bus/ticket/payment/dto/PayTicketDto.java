package org.bus.ticket.payment.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PayTicketDto {

    String firstName;
    String lastName;
    String patronymic;
    double sum;
}
