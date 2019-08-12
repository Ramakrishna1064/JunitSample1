package com.example.demo.repository;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);
	public void deleteTodo(String item);
	public void deleteItemCompletly(String item);
}
