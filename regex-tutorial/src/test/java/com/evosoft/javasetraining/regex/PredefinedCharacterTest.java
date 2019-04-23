package com.evosoft.javasetraining.regex;

import static com.evosoft.javasetraining.regex.RegexUtil.runTest;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class PredefinedCharacterTest {

	@Test
	public void givenDigits_whenMatches_thenCorrect() {
		int matches = runTest("\\d", "123");

		Assert.assertEquals(3, matches);
	}

	@Test
	public void givenNonDigits_whenMatches_thenCorrect() {
		int matches = runTest("\\D", "a6c");

		Assert.assertEquals(2, matches);
	}
	
	@Test
	public void givenWhiteSpace_whenMatches_thenCorrect() {
	    int matches = runTest("\\s", "a c");
	  
	    Assert.assertEquals(1,matches);
	}
	
	@Test
	public void givenNonWhiteSpace_whenMatches_thenCorrect() {
	    int matches = runTest("\\S", "a c");
	  
	    assertEquals(2,matches);
	}
	
	@Test
	public void givenWordCharacter_whenMatches_thenCorrect() {
	    int matches = runTest("\\w", "hi!");
	  
	    assertEquals(2,matches);
	}
	
	@Test
	public void givenNonWordCharacter_whenMatches_thenCorrect() {
	    int matches = runTest("\\W", "hi!");
	  
	    assertEquals(1,matches);
	}
}
