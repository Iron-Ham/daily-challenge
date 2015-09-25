import org.junit.Test;

import static org.junit.Assert.fail;

public class QueensTests {

    @Test
    public void testGeneticAlgorithm() {
      GeneticAlgorithm myGeneticAlgorithm = new GeneticAlgorithm();
      Integer[] solution = myGeneticAlgorithm.geneticAlgorithmSolution();
      double fitness = myGeneticAlgorithm.assessFitness(solution);

      if (fitness < 1.0) fail();
    }
}
