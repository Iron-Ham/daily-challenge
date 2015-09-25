import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

/*REQUIRES Java 1.8! I'm using Lambda expressions!
  To validate the program, please take a look at the QueensTest.java file.
 */
public class Answer {

  final int GRID_SIZE = 8; //8 Queens, but could similarly be an N-queens prob.
  final int POPULATION_SIZE = 4;
  final double MUTATION_RATE = 0.05; //5% mutation rate

  Random rand = new Random();

  /*Problem 1.
    Genetic Algorithm approach.
   */
  Integer[] geneticAlgorithmSolution() {
    List<Integer[]> population = generatePopulation();
    Double[] fitness = new Double[population.size()];
    for (int i=0; i < POPULATION_SIZE; i++) {
      fitness[i] = assessFitness(population.get(i));
    }
    while (!Arrays.asList(fitness).contains(1.0)) {
      Double[] matingProbability = probabilityOfMating(fitness);
      List<Integer[]> newPopulation = new ArrayList<Integer[]>();
      while (newPopulation.size() < POPULATION_SIZE) {
        Integer[] parent1 = pickRandomParent(population, matingProbability, null);
        Integer[] parent2 = pickRandomParent(population, matingProbability, parent1);
        Integer[] candidate = crossover(parent1, parent2);
        newPopulation.add(candidate);
      }
      population = newPopulation;
      for (int i=0; i < POPULATION_SIZE; i++) {
        fitness[i] = assessFitness(population.get(i));
      }
    }
    for (int i = 0; i < fitness.length; i++) {
      if (fitness[i] == 1.0) {
        return population.get(i);
      }
    }
    return null;
  }

  /*The maximum number of collisions that can occur is 28. So, my fitness function measures the
   number of collisions in the current array and subtracts it from 28. The percent fitness is
   calculated as (28 - # of collisions) / 28. An array with fitness 1.0 would be a solution, and an
   array with fitness 0.0 has 28 collisions (worst possible outcome).

   Assumption: This is an 8-queens and not an N-Queens problem. The MAXIMUM_COLLISIONS variable
   would have to change in an N-Queens problem.

   Time Complexity: O(1). Since the number of queens is fixed (8), and this is an n^2 algorithm, this algorithm iterates
   a fixed number of times.
   Space complexity: O(1).
  */
  double assessFitness(Integer[] candidate) {
    int collisions = 0;
    final int MAXIMUM_COLLISIONS = 28;
    for (int i = 0; i < GRID_SIZE - 1; i++) {
      for (int j = i + 1; j < GRID_SIZE; j++) {
        if ((candidate[i].equals(candidate[j])) || j - i == Math.abs(candidate[i] - candidate[j])) {
          collisions++;
        }
      }
    }
    return (MAXIMUM_COLLISIONS - collisions) / (double) MAXIMUM_COLLISIONS;
  }

  Integer[] crossover(Integer[] candidateOne, Integer[] candidateTwo) {
    int splitPoint = rand.nextInt(7) + 1; //Splits between 1 and (n - 1), where n = # of queens
    Integer[] returnValue = new Integer[GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; i++) {
      if (rand.nextDouble() <= MUTATION_RATE) {
        returnValue[i] = rand.nextInt(GRID_SIZE);
      }
      else if (i < splitPoint) {
        returnValue[i] = candidateOne[i];
      } else {
        returnValue[i] = candidateTwo[i];
      }
    }
    return returnValue;
  }

  List<Integer[]> generatePopulation() {
    List<Integer[]> returnValue = new ArrayList<Integer[]>();
    for (int i = 0; i < POPULATION_SIZE; i++) {
      Integer[] columnSet = new Integer[GRID_SIZE];
      for (int j = 0; j < GRID_SIZE; j++) {
        columnSet[j] = rand.nextInt(GRID_SIZE);
      }
      returnValue.add(columnSet);
    }
    return returnValue;
  }

  Integer[] pickRandomParent(List<Integer[]> candidates, Double[] fitness, Integer[] invalidSet) {
    while (true) {
      for (int i=0; i < POPULATION_SIZE; i++) {
        Integer[] parent = candidates.get(i);
        if (parent == invalidSet) continue;
        double val = rand.nextDouble();
        if (val <= fitness[i]) {
          return candidates.get(i);
        }
      }
    }
  }

  Double[] probabilityOfMating(Double[] fitnessOfCandidates) {
    Double[] returnValue = new Double[GRID_SIZE];
    double sum = 0;

    for (Double d : fitnessOfCandidates) {
      sum += d;
    }

    for (int i = 0; i < fitnessOfCandidates.length; i++) {
      returnValue[i] = fitnessOfCandidates[i] / sum;
    }
    return returnValue;
  }

   /*Bonus Functions.
    Generates the complete set of valid answers. May be useful for testing.

    No idea what the time/space complexity is, because I didn't take the time to calculate its Big
    O. But I can reason the "branching factor" of this algorithm by explaining how the recursive
    calls of this algorithm hit the stack.

    ways to arrange 8 queens on an 8x8 board =
      ways to arrange 8 queens on an 8x8 board with queen at (7,0)
      ways to arrange 8 queens on an 8x8 board with queen at (7, 1)
      ways to ... with queen at (7, 2)
      ways to ... with queen at (7, 3)
      ways to ... with queen at (7, 4)
      ways to ... with queen at (7, 5)
      ways to ... with queen at (7, 6)
      ways to ... with queen at (7, 7)
      = 8 branches

      Each one of these "branches" can be computed by calculating:
        ways to ... with queen at (7, 2)  =
          ways to ... with queen at (7, 2)  and (6, 0)
          ways to ... with queen at (7, 2)  and (6, 4)
          ways to ... with queen at (7, 2)  and (6, 5)
          ways to ... with queen at (7, 2)  and (6, 6)
          ways to ... with queen at (7, 2)  and (6, 7)
          = 5 branches
          (We don't need to check the other 3 possibilities, because it would violate the
          solution constraints)

          etc...

    If I had to state the general time-space complexity, perhaps O(n * n^b), where n = # of queens
    and b = the average branching factor. The n^b is pretty self explanatory -- that's the measure
    of the recursive call stack. The initial n is the amount of work done in each call.

    Once we follow this logic, we'll see that it must return an answer, and it's actually pretty
    straightforward to implement.
   */

  List<Integer[]> results = new ArrayList<Integer[]>();
  //Run to populate results with all valid solutions. Does not include mirror image solutions.
  public void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
    if (row == GRID_SIZE) {
      results.add(columns.clone());
    } else {
      for (int col = 0; col < GRID_SIZE; col++) {
        if (checkValid(columns, row, col)) {
          columns[row] = col;
          placeQueens(row + 1, columns, results);
        }
      }
    }
  }
  public void placeQueensWithDuplicates(int row, Integer[] columns, List<Integer[]> results) {
    if (row == GRID_SIZE) {
      results.add(columns.clone());
      Integer[] reverseSolution = new Integer[GRID_SIZE];
      for (int i = 0; i < GRID_SIZE; i++) {
        reverseSolution[i] = columns[columns.length - i - 1];
      }
      results.add(reverseSolution);
    } else {
      for (int col = 0; col < GRID_SIZE; col++) {
        if (checkValid(columns, row, col)) {
          columns[row] = col;
          placeQueensWithDuplicates(row + 1, columns, results);
        }
      }
    }
  }
  boolean checkValid(Integer[] columns, int row1, int column1) {
    for (int row2 = 0; row2 < row1; row2++) {
      int column2 = columns[row2];
      if (column1 == column2)
        return false;

      int columnDistance = Math.abs(column2 - column1);
      int rowDistance = row1 - row2;
      if (columnDistance == rowDistance)
        return false;
    }
    return true;
  }
}
