package com.example.demo.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MatchTestWithAnnotationWithException {

	@Mock
    Math math;
	
	@Before
	public void create() {
		initMocks(this);
		when(math.div(1, 0)).thenThrow(new ArithmeticException());
	}
	
	@Test(expected = ArithmeticException.class)
	public void div() {
		math.div(1, 0);
	}
}
