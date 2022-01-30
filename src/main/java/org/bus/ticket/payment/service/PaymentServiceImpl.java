package org.bus.ticket.payment.service;

import lombok.RequiredArgsConstructor;
import org.bus.ticket.payment.dto.PayTicketDto;
import org.bus.ticket.payment.entity.Payment;
import org.bus.ticket.payment.entity.PaymentStatus;
import org.bus.ticket.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public long buyTicket(PayTicketDto payTicketDto) {
        Payment payment = Payment.builder()
                .lastName(payTicketDto.getLastName())
                .firstName(payTicketDto.getFirstName())
                .patronymic(payTicketDto.getPatronymic())
                .sum(payTicketDto.getSum())
                .paymentStatus(PaymentStatus.NEW)
                .build();
        return paymentRepository.save(payment).getId();
    }

    @Override
    public PaymentStatus getStatusById(long paymentId) {
        List<PaymentStatus> paymentStatuses = Arrays.asList(PaymentStatus.values());
        Collections.shuffle(paymentStatuses);
        return paymentStatuses.stream().findFirst().orElse(PaymentStatus.NEW);
    }

    @Override
    public List<Payment> findAllByPaymentStatus(PaymentStatus paymentStatus) {
        return paymentRepository.findAllByPaymentStatus(paymentStatus);
    }

    @Override
    public void saveAll(List<Payment> payments) {
        paymentRepository.saveAll(payments);
    }
}
