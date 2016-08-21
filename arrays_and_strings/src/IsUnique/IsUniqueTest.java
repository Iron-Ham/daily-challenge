package IsUnique;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by heshamsalman on 8/19/16.
 */
public class IsUniqueTest {
    IsUnique iU;
    @org.junit.Before
    public void setUp() throws Exception {
        iU = new IsUnique();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        iU = null;
    }

    @Test
    public void testIsUnique_StringIsNotUnique() {
        String string = "Cool string";
        boolean expectedValue = false;
        boolean actualValue = iU.isUnique(string);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testIsUnique_StringIsUnique() {
        String string = "Colijpreqw";
        boolean expectedValue = true;
        boolean actualValue = iU.isUnique(string);
        assertEquals(expectedValue, actualValue);
    }

}