/**
 * Created by heshamsalman on 9/27/15.
 */
import java.util.Random;

public class SimulatedAnnealing {
  final int GRID_SIZE = 8;
  final int MAX_COLLISIONS = calculateMaxCollisions();
  final int MAX_ITERATIONS = -1;
  int TEMPERATURE = 35;
  final Random rand = new Random();

  int[] simulatedAnnealing() {
    int[] currentState = generateInitialState();
    int iter = 0;
    double currentStateCost = calculateStateCost(currentState);
    while((MAX_ITERATIONS == -1) || (iter < MAX_ITERATIONS) && calculateStateCost(currentState) != 0) {
      int[] neighborState = generateNeighborState(currentState);

      double neighborStateCost = calculateStateCost(neighborState);
      double costDelta = neighborStateCost - currentStateCost;
      if (costDelta > 0)
        currentState = neighborState;
      else if (rand.nextDouble() < probabilityOfAcceptance(neighborStateCost)) {
        currentState = neighborState;
      }
    }
    return currentState;
  }

  private int[] generateInitialState() {
    int[] initState = new int[GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; i++) {
      initState[i] = rand.nextInt(GRID_SIZE);
    }
    return initState;
  }

  private int[] generateNeighborState(int[] currentState) {
    int[] neighborState = currentState;
    neighborState[rand.nextInt(GRID_SIZE)] = rand.nextInt(GRID_SIZE);
    return neighborState;
  }

  private double probabilityOfAcceptance(double nextStateCost) {
    return nextStateCost / TEMPERATURE;
  }

  private double calculateStateCost(int[] state) {
    int collisions = 0;
    for (int i = 0; i < GRID_SIZE - 1; i++) {
      for (int j = i+1; j < GRID_SIZE; j++) {
        if ((state[i] == state[j]) || j - i == Math.abs(state[i] - state[j])) {
          collisions++;
        }
      }
    }
    return (MAX_COLLISIONS - collisions) / (double) MAX_COLLISIONS;
  }

  private int calculateMaxCollisions() {
    int sum = 0;
    for (int i = GRID_SIZE - 1; i > 0; i--) {
        sum += i;
    }
    return sum;
  }

}
