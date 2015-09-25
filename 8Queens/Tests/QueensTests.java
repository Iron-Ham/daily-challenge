import org.junit.Test;

import static org.junit.Assert.fail;

public class QueensTests {

    @Test
    public void testGeneticAlgorithm() {
      Answer myAnswer = new Answer();
      Integer[] solution = myAnswer.geneticAlgorithmSolution();
      double fitness = myAnswer.assessFitness(solution);

      if (fitness < 1.0) fail();
    }
}
