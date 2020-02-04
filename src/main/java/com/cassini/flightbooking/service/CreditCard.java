package com.cassini.flightbooking.service;

import org.springframework.stereotype.Service;

@Service("CreditCard")
public class CreditCard implements PaymentService {

	@Override
	public String payment(String payMode) {
		
		return "payment done through CreditCard";
		
	}

}
