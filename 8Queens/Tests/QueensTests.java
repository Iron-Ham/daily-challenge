import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;
public class QueensTests {

    @Test
    public void testGeneticAlgorithm() {
        Answer myAnswer = new Answer();
        Integer[] col = new Integer[8];

        myAnswer.placeQueensWithDuplicates(0, col, myAnswer.results);

        Integer[] solution = myAnswer.geneticAlgorithmSolution();

        boolean found = false;
        for (Integer[] validSolution : myAnswer.results) {
            if (Arrays.equals(solution, validSolution)) {
                found = true;
                break;
            }
        }
        if (!found)
            fail();
    }
}