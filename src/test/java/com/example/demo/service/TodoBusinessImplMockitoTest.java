package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.example.demo.repository.TodoService;

public class TodoBusinessImplMockitoTest {
	
	@Test
	public void usingMockito() {
		
		TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		
		assertEquals(2, todos.size());
		
	}
	
	@Test
	public void letsTestDeleteNow() {
        
		TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		
		verify(todoService).deleteTodo("Learn to Dance");
		
	}
	
	
	@Test
	public void letsTestRemoveNow() {
        
		TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		todoBusinessImpl.removeItemsCompletly("Ranga");
		
		verify(todoService).deleteItemCompletly("Learn to Dance");
	}
	
	
	@Test
    public void captureArgument() {
		
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
        TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("a")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		todoBusinessImpl.deleteTodosNotRelatedToSpring("a");
		
		verify(todoService).deleteTodo(argumentCaptor.capture());
		
		assertEquals("Learn to Dance", argumentCaptor.getValue());
		
	}
	
	
	@Test
	public void updateRow() {
        
		TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");				
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		List<String>items = todoBusinessImpl.updateItem("Ranga");
		
		assertEquals("Ramakrishna", items.get(0));
	}
}
