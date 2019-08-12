package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.repository.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoTestWithMock {
	
	@Mock
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void usingMockito() {
				
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
			
			
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		
		assertEquals(2, todos.size());
		
	}
	
	@Test
	public void letsTestDeleteNow() {
        
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
				
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		
		verify(todoService).deleteTodo("Learn to Dance");
		
	}
	
	
	@Test
	public void letsTestRemoveNow() {
        		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
				
		todoBusinessImpl.removeItemsCompletly("Ranga");
		
		verify(todoService).deleteItemCompletly("Learn to Dance");
	}
	
	
	@Test
    public void captureArgument() {
						
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("a")).thenReturn(allTodos);
				
		todoBusinessImpl.deleteTodosNotRelatedToSpring("a");
		
		verify(todoService).deleteTodo(argumentCaptor.capture());
		
		assertEquals("Learn to Dance", argumentCaptor.getValue());
		
	}
	
	
	@Test
	public void updateRow() {
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");				
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
				
		List<String>items = todoBusinessImpl.updateItem("Ranga");
		
		assertEquals("Ramakrishna", items.get(0));
	}
}
