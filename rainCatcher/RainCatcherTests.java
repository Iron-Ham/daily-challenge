import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RainCatcherTests {

	@Test
	public void testOne() {
		int[] heights = {1, 4, 2, 5, 1, 2, 3};
		int output = 5;
		assertEquals("Test one should equal 5", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testTwo() {
		int[] heights = {1, 2, 3, 2, 1};
		int output = 0;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testThree() {
		int[] heights = {1, 2, 3, 4, 5};
		int output = 0;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testFour() {
		int[] heights = {7, 6, 5, 4, 3, 2, 1};
		int output = 0;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testFive() {
		int[] heights = {2, 3, 1, 6, 4, 9, 12, 11, 3, 1, 7};
		int output = 14;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}


	@Test
	public void testSix() {
		int[] heights = {6, 1, 2, 3, 8, 1, 9, 1, 3};
		int output = 21;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testSeven() {
		int[] heights = {1, 1, 1, 1, 1};
		int output = 0;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testEight() {
		int[] heights = {1, 3, 1, 3, 1, 3, 2, 3, 1};
		int output = 5;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testNine() {
		int[] heights = {8, 10, 11, 8, 10, 11};
		int output = 4;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testTen() {
		int[] heights = {1, 8, 47, 6, 5, 6};
		int output = 1;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testEleven() {
		int[] heights = {1, 7, 2, 4};
		int output = 2;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}

	@Test
	public void testTwelve() {
		int[] heights = {1, 1, 3, 1, 2, 7, 1, 2, 1, 3, 1, 6, 1};
		int output = 25;
		assertEquals("Test two should equal 0", output, WhenItRainsItPours.answer(heights));
	}




//
//
	@Test
	public void testLocalMaxima() {
		int[] heights = {6, 1, 2, 3, 8, 1, 9, 1, 3};
		List<Integer> localMaxima = new ArrayList<Integer>();
		localMaxima.add(0);
		localMaxima.add(4);
		localMaxima.add(6);
		localMaxima.add(8);
		assertEquals("Local maxima are 0, 4 , 6, 8", localMaxima, WhenItRainsItPours.findLocalMaxima(heights));
	}


}
