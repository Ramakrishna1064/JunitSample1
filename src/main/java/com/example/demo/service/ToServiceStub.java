package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import com.example.demo.repository.TodoService;

public class ToServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}

	@Override
	public void deleteTodo(String item) {
	
	}

	@Override
	public void deleteItemCompletly(String item) {
		
	}
}
