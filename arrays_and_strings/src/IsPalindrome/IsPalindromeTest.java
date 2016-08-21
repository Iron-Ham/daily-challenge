package IsPalindrome;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class IsPalindromeTest {
    @Test
    public void isPalindrome_WhereIsPalindrome() {
        IsPalindrome isP = new IsPalindrome();

        boolean actual = isP.isPalindrome("tacocat");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void isPalindrome_WhereIsNotPalindrome() {
        IsPalindrome isP = new IsPalindrome();
        boolean actual = isP.isPalindrome("tacate");
        boolean expected = false;
        assertEquals(expected, actual);
    }

}