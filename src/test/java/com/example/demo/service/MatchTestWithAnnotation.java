package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MatchTestWithAnnotation {
	
	@Mock
    Math math;
	
	@Before
	public void create() {
		initMocks(this);
		when(math.add(2, 3)).thenReturn(5);
	}
	
	@Test
	public void add() {
		assertEquals(5, math.add(2, 3));
	}
	
	@Test
	public void addWithVerify() {
		assertEquals(5, math.add(2, 3));
		verify(math).add(2,3);
	}

}
	
