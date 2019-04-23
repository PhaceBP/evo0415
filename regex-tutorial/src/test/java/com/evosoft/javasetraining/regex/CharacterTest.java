package com.evosoft.javasetraining.regex;

import static com.evosoft.javasetraining.regex.RegexUtil.runTest;

import org.junit.Assert;
import org.junit.Test;

public class CharacterTest {

	
	//OR
	
	@Test
	public void givenORSet_whenMatchesAny_thenCorrect() {
		int matches = runTest("[abc]", "b");

		Assert.assertEquals(1,matches);
	}
	
	@Test
	public void givenORSet_whenMatchesAnyAndAll_thenCorrect() {
	    int matches = runTest("[abc]", "cab");
	  
	    Assert.assertEquals(3,matches);
	}
	
	@Test
	public void givenORSet_whenMatchesAllCombinations_thenCorrect() {
	    int matches = runTest("[bcr]at", "bat cat rat");
	  
	    Assert.assertEquals(3,matches);
	}
	
	@Test
	public void givenNORSet_whenMatchesNon_thenCorrect() {
	    int matches = runTest("[^abc]", "g");
	  
	    Assert.assertTrue(matches > 0);
	}
	
	//NOR
	
	@Test
	public void givenNORSet_whenMatchesAllExceptElements_thenCorrect() {
	    int matches = runTest("[^bcr]at", "sat bat eat");
	  
	    Assert.assertEquals(2,matches);
	}
	
	// RANGE
	
	@Test
	public void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() {
	    int matches = runTest("[A-Z]", "Two Uppercase alphabets 34 overall");
	  
	    Assert.assertEquals(2,matches);
	}
	
	@Test
	public void givenLowerCaseRange_whenMatchesLowerCase_thenCorrect() {
	    int matches = runTest(
	      "[a-z]", "Two Uppercase alphabets 34 overall");
	  
	    Assert.assertEquals(matches, 26);
	}
	
	@Test
	public void givenNumberRange_whenMatchesAccurately_thenCorrect() {
	    int matches = runTest(
	      "[1-5]", "Two Uppercase alphabets 34 overall");
	  
	    Assert.assertEquals(2,matches);
	}
	
	@Test
	public void givenNumberRange_whenMatchesAccurately_thenCorrect2(){
	    int matches = runTest(
	      "[30-35]", "Two Uppercase alphabets 34 overall");
	  
	    Assert. assertEquals(1,matches);
	}
	
	// UNION
	
	@Test
	public void givenTwoSets_whenMatchesUnion_thenCorrect() {
	    int matches = runTest("[1-3[7-9]]", "123456789");
	  
	    Assert.assertEquals(matches, 6);
	}
	
	// INTERSECTION
	
	@Test
	public void givenTwoSets_whenMatchesIntersection_thenCorrect() {
	    int matches = runTest("[1-6&&[3-9]]", "123456789");
	  
	    Assert.assertEquals(matches, 4);
	}
	
	// SUBTRACTION
	@Test
	public void givenSetWithSubtraction_whenMatchesAccurately_thenCorrect() {
	    int matches = runTest("[0-9&&[^2468]]", "123456789");
	  
	    Assert.assertEquals(matches, 5);
	}
}
