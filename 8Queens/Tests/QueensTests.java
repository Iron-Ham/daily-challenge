import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;
public class QueensTests {

    @Test
    public void testGeneticAlgorithm() {
        Answer myAnswer = new Answer();
        Integer[] col = new Integer[8];
        myAnswer.placeQueens(0, col, myAnswer.results);

        Integer[] solution = myAnswer.geneticAlgorithmSolution();

        int size = myAnswer.results.size();

        for (int i = 0; i < size; i++) {
            Integer[] mirrorImageSolution = new Integer[8];
            Integer[] validSolution = myAnswer.results.get(i);
            for (int j = 0; j < 8; j++) {
                mirrorImageSolution[j] = validSolution[validSolution.length - j - 1];
            }
            myAnswer.results.add(mirrorImageSolution);
        }

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