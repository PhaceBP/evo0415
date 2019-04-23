package com.evosoft.javasetraining.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class BasicsTest {

	@Test
	public void givenText_whenSimpleRegexMatches_thenCorrect() {
		Pattern pattern = Pattern.compile("foo");
		Matcher matcher = pattern.matcher("foo");

		Assert.assertTrue(matcher.find());
	}
	
	@Test
	public void givenText_whenSimpleRegexMatchesTwice_thenCorrect() {
	    Pattern pattern = Pattern.compile("foo");
	    Matcher matcher = pattern.matcher("foofoo");
	    int matches = 0;
	    while (matcher.find()) {
	        matches++;
	    }
	  
	    Assert.assertEquals(matches, 2);
	}

}
