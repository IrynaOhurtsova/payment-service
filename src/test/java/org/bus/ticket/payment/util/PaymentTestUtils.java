package org.bus.ticket.payment.util;

import lombok.experimental.UtilityClass;
import org.bus.ticket.payment.dto.PayTicketDto;
import org.bus.ticket.payment.entity.Payment;
import org.bus.ticket.payment.entity.PaymentStatus;

@UtilityClass
public class PaymentTestUtils {

    public static final Payment PAYMENT_WITHOUT_ID_AND_NEW_STATUS = Payment.builder()
            .firstName("Ivan")
            .lastName("Ivanov")
            .patronymic("Ivanovich")
            .sum(500)
            .paymentStatus(PaymentStatus.NEW).build();
    public static final Payment PAYMENT_WITH_FAILED_STATUS = PAYMENT_WITHOUT_ID_AND_NEW_STATUS.toBuilder()
            .id(1L)
            .paymentStatus(PaymentStatus.FAILED).build();
    public static final Payment PAYMENT_WITH_NEW_STATUS = PAYMENT_WITH_FAILED_STATUS.toBuilder()
            .paymentStatus(PaymentStatus.NEW).build();
    public static final Payment PAYMENT_WITH_DONE_STATUS = PAYMENT_WITH_FAILED_STATUS.toBuilder()
            .paymentStatus(PaymentStatus.DONE).build();
    public static final PayTicketDto PAY_TICKET_DTO = PayTicketDto.builder()
            .firstName(PAYMENT_WITH_FAILED_STATUS.getFirstName())
            .lastName(PAYMENT_WITH_FAILED_STATUS.getLastName())
            .patronymic(PAYMENT_WITH_FAILED_STATUS.getPatronymic())
            .sum(PAYMENT_WITH_FAILED_STATUS.getSum()).build();
}
