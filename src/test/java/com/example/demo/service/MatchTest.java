package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class MatchTest {
	
	Math math;
	
	@Before
	public void create() {
		math = mock(Math.class);
		when(math.add(2, 3)).thenReturn(5);
	}
	
	@Test
	public void add() {
		assertEquals(5, math.add(2, 3));
	}

}
