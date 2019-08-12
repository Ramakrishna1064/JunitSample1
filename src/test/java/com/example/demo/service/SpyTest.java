package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {
	
	@Test
	public void creatingASpyOnArrayList() {
		
		List<String>list = spy(ArrayList.class);
		list.add("Ram");
		list.add("Rita");
		
		verify(list).add("Ram");
		verify(list).add("Rita");
		
		
		assertEquals(2, list.size());
		assertEquals("Ram", list.get(0));
	}
	
	
	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");
		
		doReturn(-1).when(listSpy).size();
		
		assertEquals(-1, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
	}
}
