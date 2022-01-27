package org.bus.ticket.payment.repository;

import org.bus.ticket.payment.entity.Payment;
import org.bus.ticket.payment.entity.PaymentStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findAllByPaymentStatus(PaymentStatus paymentStatus);
}
