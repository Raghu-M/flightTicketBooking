package com.cassini.flightbooking.service;

import org.springframework.stereotype.Service;

@Service("Upi")
public class Upi implements PaymentService {

	@Override
	public String payment(String payMode) {
		
		return "payment done through UPI";
	}

}
