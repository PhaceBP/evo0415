package com.evosoft.javasetraining.regex;

import static com.evosoft.javasetraining.regex.RegexUtil.runTest;

import org.junit.Assert;
import org.junit.Test;

public class MetaCharacterTest {

	@Test
	public void givenText_whenMatchesWithDotMetach_thenCorrect() {
		int matches = runTest(".", "foo");

		Assert.assertTrue(matches == 3);
	}

	@Test
	public void givenRepeatedText_whenMatchesOnceWithDotMetach_thenCorrect() {
		int matches = runTest("foo.", "foofoo");

		Assert.assertEquals(1, matches);
	}
}
