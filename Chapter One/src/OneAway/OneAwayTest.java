package OneAway;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class OneAwayTest {

    OneAway oneAway = new OneAway();

    @Test
    public void oneAway_Replacement() {
        String target = "cake";
        String test = "make";

        boolean expected = true;
        boolean actual = oneAway.oneAway(target, test);
        assertEquals(expected, actual);
    }

    @Test
    public void oneAway_Removal() {
        String target = "cake";
        String test = "ake";

        boolean expected = true;
        boolean actual = oneAway.oneAway(target, test);
        assertEquals(expected, actual);
    }

    @Test
    public void oneAway_Addition() {
        String target = "cake";
        String test = "cakes";

        boolean expected = true;
        boolean actual = oneAway.oneAway(target, test);
        assertEquals(expected, actual);
    }

    @Test
    public void oneAway_NotOneAway() {
        String target = "cake";
        String test = "tape";

        boolean expected = false ;
        boolean actual = oneAway.oneAway(target, test);
        assertEquals(expected, actual);
    }

}
