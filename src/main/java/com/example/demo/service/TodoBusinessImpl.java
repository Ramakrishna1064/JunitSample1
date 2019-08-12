package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.TodoService;

public class TodoBusinessImpl {
	
	private TodoService todoService;
	
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String item) {
		List<String> allTodos = todoService.retrieveTodos(item);
		for(String todo:allTodos) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
	
	
	public void removeItemsCompletly(String item) {
		List<String> allTodos = todoService.retrieveTodos(item);
		for(String todo:allTodos) {
			if(!todo.contains("Spring")) {
				todoService.deleteItemCompletly(todo);
			}
		}
	}
	
	
	public List<String> updateItem(String item) {
		List<String> allTodos = todoService.retrieveTodos(item);
		allTodos.set(0, "Ramakrishna");
		return allTodos;
	}
}
