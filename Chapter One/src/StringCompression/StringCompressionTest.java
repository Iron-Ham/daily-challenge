package StringCompression;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class StringCompressionTest {

    StringCompression sc = new StringCompression();

    @Test
    public void compress_validCompressionTarget() {
        String inputString = "aabcccccaaa";
        String expected = "a2b1c5a3";
        String actual = sc.compress(inputString);
        assertEquals(expected, actual);
    }

    @Test
    public void compress_invalidCompressionTarget() {
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        String expected = inputString;
        String actual = sc.compress(inputString);
        assertEquals(expected, actual);
    }

    @Test
    public void compress_alternatelyInvalidTarget() {
        String inputString = "ababababababababababababab";
        String expected = inputString;
        String actual = sc.compress(inputString);

        assertEquals(expected, actual);
    }

}