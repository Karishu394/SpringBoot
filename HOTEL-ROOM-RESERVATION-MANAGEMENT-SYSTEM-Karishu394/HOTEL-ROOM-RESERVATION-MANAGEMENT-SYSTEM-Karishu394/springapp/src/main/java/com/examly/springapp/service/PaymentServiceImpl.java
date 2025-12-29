package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepo.save(payment);
    }
}