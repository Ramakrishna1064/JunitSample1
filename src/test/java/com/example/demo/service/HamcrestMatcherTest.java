package com.example.demo.service;


import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Test;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;

public class HamcrestMatcherTest {
	
	@Test
	public void basicHamcrestMatchers() {
		
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		assertThat(scores,hasSize(4));
		assertThat(scores,hasItem(99));
		assertThat(scores,everyItem(greaterThan(90)));
		
		// String
		assertThat("",isEmptyString());
		assertThat(null,isEmptyOrNullString());
		
		//Array
		Integer[] marks = { 1, 2, 3 };
		
		assertThat(marks,arrayWithSize(3));
		assertThat(marks,arrayContainingInAnyOrder(3,2,1));
	}

}
