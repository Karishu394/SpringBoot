package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import java.util.List;

public interface PaymentService {

    Payment addPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    Payment updatePayment(Payment payment);
}
