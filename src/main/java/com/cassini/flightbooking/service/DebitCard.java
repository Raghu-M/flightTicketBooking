package com.cassini.flightbooking.service;

import org.springframework.stereotype.Service;

@Service("DebitCard")
public class DebitCard implements PaymentService {

	@Override
	public String payment(String payMode) {
		
		return "payment done through DebitCard";
	}

}
