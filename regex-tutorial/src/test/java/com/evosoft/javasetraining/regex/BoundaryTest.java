package com.evosoft.javasetraining.regex;

import static com.evosoft.javasetraining.regex.RegexUtil.runTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class BoundaryTest {

	@Test
	public void givenText_whenMatchesAtBeginning_thenCorrect() {
		int matches = runTest("^dog", "dogs are friendly");

		assertTrue(matches > 0);
	}

	@Test
	public void givenTextAndWrongInput_whenMatchFailsAtBeginning_thenCorrect() {
		int matches = runTest("^dog", "are dogs are friendly?");

		assertFalse(matches > 0);
	}

	@Test
	public void givenText_whenMatchesAtEnd_thenCorrect() {
		int matches = runTest("dog$", "Man's best friend is a dog");

		assertTrue(matches > 0);
	}

	@Test
	public void givenTextAndWrongInput_whenMatchFailsAtEnd_thenCorrect() {
		int matches = runTest("dog$", "is a dog man's best friend?");

		assertFalse(matches > 0);
	}

	@Test
	public void givenText_whenMatchesAtWordBoundary_thenCorrect() {
		int matches = runTest("\\bdog\\b", "a dog is friendly");

		assertTrue(matches > 0);
	}

	@Test
	public void givenText_whenMatchesAtWordBoundary_thenCorrect2() {
		int matches = runTest("\\bdog\\b", "dog is man's best friend");

		assertTrue(matches > 0);
	}

	@Test
	public void givenWrongText_whenMatchFailsAtWordBoundary_thenCorrect() {
		int matches = runTest("\\bdog\\b", "snoop dogg is a rapper");

		assertFalse(matches > 0);
	}

	@Test
	public void givenText_whenMatchesAtWordAndNonBoundary_thenCorrect() {
		int matches = runTest("\\bdog\\B", "snoop dogg is a rapper");
		assertTrue(matches > 0);
	}

	@Test
	public void givenRegexWithDefaultMatcher_whenMatchFailsOnDifferentCases_thenCorrect() {
		int matches = runTest("dog", "This is a Dog");

		assertFalse(matches > 0);
	}

	// PATTERN FLAGS
	@Test
	public void givenRegexWithCaseInsensitiveMatcher_whenMatchesOnDifferentCases_thenCorrect() {
		int matches = runTest("dog", "This is a Dog", Pattern.CASE_INSENSITIVE);

		assertTrue(matches > 0);
	}

	@Test
	public void givenRegexWithComments_whenMatchesWithFlag_thenCorrect() {
		int matches = runTest("dog$  #check end of text", "This is a dog", Pattern.COMMENTS);

		assertTrue(matches > 0);
	}

	@Test
	public void givenRegexWithLineTerminator_whenMatchesWithDotall_thenCorrect() {
		Pattern pattern = Pattern.compile("(.*)", Pattern.DOTALL);
		java.util.regex.Matcher matcher = pattern
				.matcher("this is a text" + System.getProperty("line.separator") + " continued on another line");
		matcher.find();
		Assert.assertEquals("this is a text" + System.getProperty("line.separator") + " continued on another line",
				matcher.group(1));
	}

	@Test
	public void givenRegex_whenMatchesWithMultilineFlag_thenCorrect() {
		int matches = runTest("dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox",
				Pattern.MULTILINE);

		assertTrue(matches > 0);
	}
}
