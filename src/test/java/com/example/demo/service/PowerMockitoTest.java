package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import com.example.demo.dao.OrderRequest;
import com.example.demo.util.NotifiucationUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.example.demo.*")
public class PowerMockitoTest {

	@InjectMocks
	OrderService orderService;
	
	OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "test@gmail.com", true);
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(NotifiucationUtil.class);
	}
	
	@Test
	public void testStaticMethod() {
		
		PowerMockito.mockStatic(NotifiucationUtil.class);
	
		when(NotifiucationUtil.sendEmail("sam@gmail.com")).thenReturn("Success");
		
		OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "sam@gmail.com", true);
    	OrderResponse response = orderService.checkoutOrder(request);
		assertEquals("Success", NotifiucationUtil.sendEmail("sam@gmail.com"));
	}
	
	
	@Test
	public void testPrivateMethod() throws Exception {
		// When
		OrderService spy = PowerMockito.spy(orderService);
		doReturn(200000).when(spy, "addDiscount", ArgumentMatchers.any());
		// Then
		OrderResponse response = spy.checkoutOrder(request);
		int price = response.getResponse().getPrice();
		assertEquals(200000, price);
	}

}
