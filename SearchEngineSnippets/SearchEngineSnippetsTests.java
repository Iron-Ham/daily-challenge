import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SearchEngineSnippetsTests {

	@Test
	public void testOne() {
		String answer = "google employees can program";
		String document = "many google employees can program";
		String[] searchTerms = {"google", "program"};
		assertEquals("test one must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testTwo() {
		String answer = "friend once";
		String document = "once in a long time there friend once was a brown cat that had a jack in the box for a friend";
		String[] searchTerms = {"once", "friend"};
		assertEquals("test two must be \"friend once\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testThree() {
		String answer = "howdy google can program";
		String document = "many google google employees howdy google can program once howdy google";
		String[] searchTerms = {"google", "program", "howdy"};
		assertEquals("test three must be \"howdy google can program\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testFour() {
		String answer = "c d a";
		String document = "a b c d a";
		String[] searchTerms = {"a", "c", "d"};
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testFive() {
		String answer = "d c a";
		String document = "d c a b c d a e a b d c d b a b d a b c d b a b d d e f g i j k l k m b a d c";
		String[] searchTerms = {"a", "c", "d"};
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testSix() {
		String answer = "world there hello";
		String document = "world there hello hello where world";
		String[] searchTerms = {"hello", "world"};
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testSeven() {
		String answer = "google";
		String document = "google";
		String[] searchTerms = {"google"};
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testEight() {
		String document = "one a long time ago there was a princess who lived in a fancy fairtail world where once in a while some people were able to conflict with the person in the other room but sometime when the last thing upi want to look at is wjat";
		String answer = "fairtail world where once in a while some people were able to conflict with the person in the other room but sometime when the last thing upi want to look";
		String[] searchTerms = {"fairtail", "a", "look"};
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testNine() {
		String document = "the long tail of the google exam is googles own tail when google finds it";
		String answer = "tail when google";
		String[] searchTerms = {"tail", "google"};
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testTen() {
		String document = "a b a a b d";
		String[] searchTerms = {"a"};
		String answer = "a";
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testEleven() {
		String document = "a google a a google a b d";
		String[] searchTerms = {"a", "google"};
		String answer = "a google";
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testTwelve() {
		String document = "once in a long time there friend once was a brown cat that had a jack in the box for a friend";
		String[] searchTerms = {"once", "friend"};
		String answer = "friend once";
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testThirteen() {
		String document = "google google google google goole cat";
		String[] searchTerms = {"cat", "google"};
		String answer = "google goole cat";
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testFourteen() {
		String document = "hello a google one hello two google g hello";
		String[] searchTerms = {"hello", "google"};
		String answer = "hello a google";
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}

	@Test
	public void testFifteen() {
		String document = "google google google google google google gool gool cat cat cat gool cat goole pat cat google";
		String[] searchTerms = {"pat", "cat", "google", "gool"};
		String answer = "gool cat goole pat cat google";
		assertEquals("test four must be \"c d a\"", answer, SpySnippets.answer(document, searchTerms));
	}
}
