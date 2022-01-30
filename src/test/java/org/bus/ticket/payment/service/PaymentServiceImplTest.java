package org.bus.ticket.payment.service;

import org.bus.ticket.payment.entity.Payment;
import org.bus.ticket.payment.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.bus.ticket.payment.entity.PaymentStatus.NEW;
import static org.bus.ticket.payment.util.PaymentTestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    void buyTicket() {
        when(paymentRepository.save(PAYMENT_WITHOUT_ID_AND_NEW_STATUS)).thenReturn(PAYMENT_WITH_NEW_STATUS);

        assertEquals(PAYMENT_WITH_NEW_STATUS.getId(), paymentService.buyTicket(PAY_TICKET_DTO));
    }

    @Test
    void findAllByPaymentStatus() {
        List<Payment> payments = Collections.singletonList(PAYMENT_WITH_NEW_STATUS);

        when(paymentRepository.findAllByPaymentStatus(NEW)).thenReturn(payments);

        assertEquals(payments, paymentService.findAllByPaymentStatus(NEW));
    }

    @Test
    void saveAll() {
        List<Payment> payments = Collections.singletonList(PAYMENT_WITH_NEW_STATUS);

        when(paymentRepository.saveAll(payments)).thenReturn(payments);

        paymentService.saveAll(payments);
    }
}