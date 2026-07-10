package com.example.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/{product}")
	public String pay(@PathVariable String product) {
		return paymentService.processPayment(product);
	}
	
	// @PostMapping
	// public Payment savePayment(@RequestBody Payment payment) {
	// 	return service.savePayment(payment);
	// }
	
	// @GetMapping
	// public List<Payment> getAllPayments(){
	// 	return service.getAllPayments();
	// }
	
	// @GetMapping("/{id}")
	// public Payment getPayment(@PathVariable Long id) {
	// 	return service.getPaymentById(id);
	// }
}
