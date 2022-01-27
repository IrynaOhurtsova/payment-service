package org.bus.ticket.payment.service;

import org.bus.ticket.payment.dto.PayTicketDto;
import org.bus.ticket.payment.entity.Payment;
import org.bus.ticket.payment.entity.PaymentStatus;

import java.util.List;

public interface PaymentService {

    long buyTicket(PayTicketDto payTicketDto);

    PaymentStatus getStatusById(long paymentId);

    List<Payment> findAllByPaymentStatus(PaymentStatus paymentStatus);

    void saveAll(List<Payment> payments);
}
