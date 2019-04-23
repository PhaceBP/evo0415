package com.evosoft.javasetraining.regex;

import static com.evosoft.javasetraining.regex.RegexUtil.runTest;

import org.junit.Assert;
import org.junit.Test;

public class QuantifierTest {

	@Test
	public void givenText_whenMatchesZeroOrMoreCharacterReluctant_thenCorrect() {
		int matches = runTest("John.*?", "John went for a walk, and John fell down, and John hurt his knee.");
		Assert.assertEquals(3, matches);
	}

	@Test
	public void givenText_whenMatchesZeroOrMoreCharacterGreedy_thenCorrect() {
		int matches = runTest("John.*", "John went for a walk, and John fell down, and John hurt his knee.");
		Assert.assertEquals(1, matches);
	}

	@Test
	public void givenText_whenMatchesZeroOrMoreCharacterPossesive_thenCorrect() {
		int matches = runTest("John.*+hurt", "John went for a walk, and John fell down, and John hurt his knee.");
		Assert.assertEquals(0, matches);
	}
	
	@Test
	public void givenBraceQuantifier_whenMatches_thenCorrect() {
	    int matches = runTest("a{3}", "aaaaaa");
	  
	    Assert.assertEquals(matches, 2);
	}
	
	@Test
	public void givenBraceQuantifierWithRange_whenMatches_thenCorrect() {
	    int matches = runTest("a{2,3}", "aaaa");
	  
	    Assert.assertEquals(matches, 1);
	}
	
	@Test
	public void givenBraceQuantifierWithRange_whenMatchesLazily_thenCorrect() {
	    int matches = runTest("a{2,3}?", "aaaa");
	  
	    Assert.assertEquals(matches, 2);
	}
}
