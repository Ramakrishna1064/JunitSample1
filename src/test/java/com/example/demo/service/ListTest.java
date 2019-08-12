package com.example.demo.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	
	@Test
	public void letsMockListSize() {
		List<?> list= mock(List.class);
		when(list.size()).thenReturn(2);
		assertEquals(2, list.size());
	}
	
	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List<?> list= mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, list.size());
		assertEquals(3, list.size());
	}
	
	@Test
	public void letsMockListGet() {
		List<String> list= mock(List.class);
		when(list.get(0)).thenReturn("Ram");
		assertEquals("Ram", list.get(0));
		assertNull(list.get(1));
	}
	
	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("in28Minutes");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("in28Minutes", list.get(10));
		assertEquals("in28Minutes", list.get(1));
	}
	
	@Test
	public void bddAliases_UsingGivenWillReturn() {
		List<String> list = mock(List.class);
		//given
		given(list.get(Mockito.anyInt())).willReturn("in28Minutes");
		//then
		assertThat("in28Minutes", is(list.get(0)));
		assertThat("in28Minutes", is(list.get(0)));
	}
	
	@Test(expected = RuntimeException.class)
	public void letsMockListGetToThrowException() {
		List<String> list = mock(List.class);
		when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException());
		assertEquals(new RuntimeException(), list.get(0));
		//list.get(0);
	}

}
