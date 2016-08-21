package StringRotation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class StringRotationTest {

    StringRotation sr = new StringRotation();

    @Test
    public void isSubstring_WhereIsSubstring() {
        String ofString = "Reddit";
        String s = "red";

        boolean expected = true;
        boolean actual = sr.isSubstring(s, ofString);
        assertEquals(expected, actual);
    }

    @Test
    public void isSubstring_WhereIsNotSubstring() {
        String ofString = "Manhattan";
        String s = "Chicago";

        boolean expected = false;
        boolean actual = sr.isSubstring(s, ofString);
        assertEquals(expected, actual);
    }

    @Test
    public void isRotation_WhereIsRotation() {
        String ofString = "erbottlewat";
        String s = "waterbottle";

        boolean expected = true;
        boolean actual = sr.isRotation(s, ofString);
        assertEquals(expected, actual);
    }

    @Test
    public void isRotation_WhereIsNotRotation() {
        String ofString = "reddit";
        String s = "red";

        boolean expected = false;
        boolean actual = sr.isRotation(s, ofString);
        assertEquals(expected, actual);
    }

    @Test
    public void isRotation_WhereIsNotRotation2() {
        String ofString = "reddit";
        String s = "redred";

        boolean expected = false;
        boolean actual = sr.isRotation(s, ofString);
        assertEquals(expected, actual);
    }
}