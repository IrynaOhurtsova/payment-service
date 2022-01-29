package org.bus.ticket.payment.controller;

import lombok.RequiredArgsConstructor;
import org.bus.ticket.payment.dto.PayTicketDto;
import org.bus.ticket.payment.dto.PayTicketResultDto;
import org.bus.ticket.payment.entity.Payment;
import org.bus.ticket.payment.entity.PaymentStatus;
import org.bus.ticket.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/buy")
    public PayTicketResultDto buyTicket(@RequestBody PayTicketDto payTicketDto) {
        return new PayTicketResultDto(paymentService.buyTicket(payTicketDto));
    }

    @GetMapping("/{paymentId}/status")
    public PaymentStatus getStatusById(@PathVariable("paymentId") long paymentId) {
        return paymentService.getStatusById(paymentId);
    }

    @GetMapping("/{status}")
    public List<Payment> findAllByPaymentStatus(@PathVariable("status") PaymentStatus paymentStatus) {
        return paymentService.findAllByPaymentStatus(paymentStatus);
    }

    @PostMapping("/update")
    public void saveAll(@RequestBody List<Payment> payments) {
        paymentService.saveAll(payments);
    }


}
