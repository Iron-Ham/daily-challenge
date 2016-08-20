package CheckPermutation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class CheckPermutationTest {

    CheckPermutation cP;

    @Before
    public void setUp() throws Exception {
        cP = new CheckPermutation();
    }

    @Test
    public void isPermutation_WhereIsNotPermutation() {
        String a = "bananabreaddington";
        String b = "racecar";
        boolean expected = false;
        boolean actual = cP.isPermutation(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void isPermutation_WhereIsPermutation() {
        String a = "spaceman";
        String b = "manspace";

        boolean expected = true;
        boolean actual = cP.isPermutation(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void isPermutationThroughSort_WhereIsNotPermutation() {
        String a = "island";
        String b = "bonono";

        boolean expected = false;
        boolean actual = cP.isPermuationThroughSort(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void isPermutationThroughSort_WhereIsPermutation() {
        String a = "phone";
        String b = "nophe";

        boolean expected = true;
        boolean actual = cP.isPermuationThroughSort(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void isPermutationThroughIntMapping_WhereIsNotPermutation() {
        String a = "island";
        String b = "inthesun";

        boolean expected = false;
        boolean actual = cP.isPermutationThroughIntMapping(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void isPermutationThroughIntMapping_WhereIsPermutation() {
        String a = "island";
        String b = "siland";

        boolean expected = true;
        boolean actual = cP.isPermutationThroughIntMapping(a, b);
        assertEquals(expected, actual);
    }

}