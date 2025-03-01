package com.kafka.payment_service.controller;

import com.kafka.payment_service.dto.PaymentDto;
import com.kafka.payment_service.entity.PaymentId;
import com.kafka.payment_service.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
@Validated
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/new")
    public PaymentDto addPayment(@RequestBody @Valid PaymentDto paymentDto){
        return paymentService.addPayment(paymentDto);
    }

    @PutMapping()
    public PaymentDto updatePayment(@RequestBody @Valid PaymentDto paymentDto){
        return paymentService.updatePayment(paymentDto);
    }

    @PostMapping()
    public Optional<PaymentDto> getPayment(@RequestBody @Valid PaymentId paymentId){
        return paymentService.getPayment(paymentId);
    }

    @DeleteMapping()
    public void deletePayment(@RequestBody @Valid PaymentId paymentId){
        paymentService.deletePayment(paymentId);
    }

}
