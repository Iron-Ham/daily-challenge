package URLify;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class URLifyTest {
    URLify urlify;
    @Before
    public void setUp() throws Exception {
        urlify = new URLify();
    }

    @Test
    public void URLify() throws Exception {
        char[] inputArray = new char[17];
        String s = "Mr John Smith";
        int i = 0;
        for (char c : s.toCharArray()) {
            inputArray[i++] = c;
        }

        String expected = "Mr%20John%20Smith";
        String actual = urlify.URLify(inputArray, 13);
        assertEquals(expected, actual);
    }

}