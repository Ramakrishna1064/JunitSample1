package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.dao.OrderRequest;
import com.example.demo.util.NotifiucationUtil;

@Service
public class OrderService {

	public OrderResponse checkoutOrder(OrderRequest order) {
		int disscount = addDiscount(order);
		order.setPrice(disscount);
	    String message = NotifiucationUtil.sendEmail(order.getEmailId());
		return new OrderResponse(order,message, HttpStatus.OK.value());
	}
	
	private int addDiscount(OrderRequest order) {
		
		int price = order.getPrice();
		int discountAMount = 0;
		if (order.isDiscountable()) {
			if (order.getPrice() < 1000) {
				discountAMount = price * 10 / 100;
			} else {
				discountAMount = price;
			}
		} else {
			discountAMount = price;
		}
		return discountAMount;
	}
}
