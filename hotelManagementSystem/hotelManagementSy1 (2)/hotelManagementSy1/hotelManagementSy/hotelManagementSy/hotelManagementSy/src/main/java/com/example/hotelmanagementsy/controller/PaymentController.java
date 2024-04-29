package com.example.hotelmanagementsy.controller;

import com.example.hotelmanagementsy.model.Payment;
import com.example.hotelmanagementsy.repository.PaymentRepository;
import com.example.hotelmanagementsy.service.PaymentService;
import com.example.hotelmanagementsy.service.CashPaymentStrategy;
import com.example.hotelmanagementsy.service.OnlinePaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List; // Add this import for List

@Controller
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository; // Inject PaymentRepository

    @Autowired
    public PaymentController(PaymentService paymentService, PaymentRepository paymentRepository) {
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/payment")
    public String showPayments() {
        return "payment"; // Assuming there's a payments.html template
    }

    @PostMapping("/process")
    public String processPayment(@RequestParam("paymentType") String paymentType,
                                 @RequestParam("amount") BigDecimal amount,
                                 Model model) {
        // Create a new Payment object
        Payment payment = new Payment();
        payment.setReservationId(18);
        payment.setPaymentMethod(paymentType);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDate.now());

        // Determine the payment strategy based on the payment type
        if (paymentType.equalsIgnoreCase("cash")) {
            paymentService.setPaymentStrategy(new CashPaymentStrategy());
        } else if (paymentType.equalsIgnoreCase("online")) {
            paymentService.setPaymentStrategy(new OnlinePaymentStrategy());
        } else {
            // Handle invalid payment type
            return "error"; // Assuming there's an error.html template
        }

        // Process the payment using the selected strategy
        paymentService.processPayment(payment);
        paymentService.savePayment(payment);

        // Add payment details to the model
        model.addAttribute("payment", payment);

        return  "payment-success"; // Assuming there's a payment-result.html template
    }
}
