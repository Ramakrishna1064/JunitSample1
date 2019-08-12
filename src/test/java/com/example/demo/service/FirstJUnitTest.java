package com.example.demo.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.example.demo.repository.TodoService;

public class FirstJUnitTest {

	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void usingAStub() {
		TodoService todoService = new ToServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}
