import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*REQUIRES Java 1.8!
  To validate the program, please take a look at the QueensTest.java file.

  Contents:
  (1) Genetic Algorithm Approach
 */

class GeneticAlgorithm {
    private final int GRID_SIZE = 8; //8 Queens but could be an N-queens prob. Fitness function will auto-magically adjust
    private final int POPULATION_SIZE = 6;
    private final double MUTATION_RATE = 0.05; //1.0 = 100% mutation rate
    private final double CULLING_THRESHOLD = (1 / POPULATION_SIZE) * 0.85;
    private final int MAX_ITERATIONS = -1; //-1 == INFINITE
    private final Random rand = new Random();

    Integer[] geneticAlgorithmSolution() {
        List<Integer[]> population = generatePopulation();
        Double[] fitness = new Double[population.size()];
        int currentIteration = 0;
        for (int i = 0; i < POPULATION_SIZE; i++) {
            fitness[i] = assessFitness(population.get(i));
        }
        while (!populationContainsSolution(population, fitness) && ((MAX_ITERATIONS == -1) || currentIteration < MAX_ITERATIONS)) {
            Double[] matingProbability = probabilityOfMating(fitness);
            List<Integer[]> newPopulation = new ArrayList<>();
            while (newPopulation.size() < POPULATION_SIZE) {
                Integer[] parent1 = pickRandomParent(population, matingProbability, null);
                Integer[] parent2 = pickRandomParent(population, matingProbability, parent1);
                Integer[] candidate = crossover(parent1, parent2);
                newPopulation.add(candidate);
            }
            population = newPopulation;
            for (int i = 0; i < POPULATION_SIZE; i++) {
                fitness[i] = assessFitness(population.get(i));
            }
            currentIteration++;
        }
        Integer[] candidate = population.get(0);
        for (int i = 0; i < fitness.length; i++) {
            if (fitness[i] == 1.0) {
                return population.get(i);
            }
            if (assessFitness(candidate) < fitness[i])
                candidate = population.get(i);
        }
        return candidate;
    }

    private boolean populationContainsSolution(List<Integer[]> population, Double[] fitness) {
        for (int i = 0; i < population.size(); i++) {
            if (fitness[i] == 1.0) {
                return true;
            }
        }
        return false;
    }

    /*The maximum number of collisions that can occur is 28. So, my fitness function measures the
     number of collisions in the current array and subtracts it from 28. The percent fitness is
     calculated as (28 - # of collisions) / 28. An array with fitness 1.0 would be a solution, and an
     array with fitness 0.0 has 28 collisions (worst possible outcome).

     Time Complexity: O(1). Since the number of queens is fixed (8), and this is an n^2 algorithm, this algorithm iterates
     a fixed number of times.
     Space complexity: O(1).
    */
    double assessFitness(Integer[] candidate) {
        int collisions = 0;
        final int MAXIMUM_COLLISIONS = calculateMaxCollisions();
        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = i + 1; j < GRID_SIZE; j++) {
                if ((candidate[i].equals(candidate[j])) || j - i == Math.abs(candidate[i] - candidate[j]))
                    collisions++;
            }
        }
        return (MAXIMUM_COLLISIONS - collisions) / (double) MAXIMUM_COLLISIONS;
    }

    private int calculateMaxCollisions() {
        int sum = 0;
        for (int i = GRID_SIZE - 1; i > 0; i--) {
            sum += i;
        }
        return sum;
    }

    private Integer[] crossover(Integer[] candidateOne, Integer[] candidateTwo) {
        int splitPoint = rand.nextInt(GRID_SIZE - 1) + 1; //Splits between 1 and (n - 1), where n = # of queens
        Integer[] returnValue = new Integer[GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            if (rand.nextDouble() <= MUTATION_RATE)
                returnValue[i] = rand.nextInt(GRID_SIZE);
            else if (i < splitPoint)
                returnValue[i] = candidateOne[i];
            else
                returnValue[i] = candidateTwo[i];
        }
        return returnValue;
    }

    private List<Integer[]> generatePopulation() {
        List<Integer[]> returnValue = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Integer[] columnSet = new Integer[GRID_SIZE];
            for (int j = 0; j < GRID_SIZE; j++) {
                columnSet[j] = rand.nextInt(GRID_SIZE);
            }
            returnValue.add(columnSet);
        }
        return returnValue;
    }

    private Integer[] pickRandomParent(List<Integer[]> candidates, Double[] fitness, Integer[] invalidSet) {
        while (true) {
            for (int i = 0; i < POPULATION_SIZE; i++) {
                if (candidates.get(i) == invalidSet || fitness[i] < CULLING_THRESHOLD)
                    continue;
                double val = rand.nextDouble();
                if (val <= fitness[i]) {
                    return candidates.get(i);
                }
            }
        }
    }

    private Double[] probabilityOfMating(Double[] fitnessOfCandidates) {
        Double[] returnValue = new Double[POPULATION_SIZE];
        double sum = 0;
        for (Double d : fitnessOfCandidates) {
            sum += d;
        }

        for (int i = 0; i < fitnessOfCandidates.length; i++) {
            returnValue[i] = fitnessOfCandidates[i] / sum;
        }
        return returnValue;
    }
}
