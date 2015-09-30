/**
 * Created by heshamsalman on 9/27/15.
 */

import java.util.Random;

public class SimulatedAnnealing {
    final int GRID_SIZE = 8;
    final int MAX_COLLISIONS = calculateMaxCollisions();
    final int MAX_ITERATIONS = -1;
    final Random rand = new Random();
    final double INITIAL_TEMP = 100;
    double temp = INITIAL_TEMP;

    int[] simulatedAnnealing() {
        int[] currentState = generateInitialState();
        int iter = 0;
        while (MAX_ITERATIONS == -1 || iter < MAX_ITERATIONS) {
            temp = calculateTemp();
            double currentStateFitness = calculateStateCost(currentState);
            if (currentStateFitness == 1.0) return currentState;
            int[] nextState = generateNeighborState(currentState);
            double nextStateFitness = calculateStateCost(nextState);

            double delta = nextStateFitness - currentStateFitness;
            if (delta > 0) {
                currentState = nextState;
            } else if (rand.nextDouble() <= probabilityOfAcceptance(delta, temp)) {
                currentState = nextState;
            }

            iter++;
        }
        return currentState;
    }

    /* Geometric function. Alt. can be a logarithmic function*/
    private double calculateTemp() {
        return temp * 0.97;
    }

    private int[] generateInitialState() {
        int[] initState = new int[GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            initState[i] = rand.nextInt(GRID_SIZE);
        }
        return initState;
    }

    private int[] generateNeighborState(int[] currentState) {
        int i = rand.nextInt(GRID_SIZE);
        int j = rand.nextInt(GRID_SIZE);
        currentState[i] = j;
        return currentState;
    }

    private double probabilityOfAcceptance(double delta, double temperature) {
        return Math.exp(delta / temperature);
    }

    double calculateStateCost(int[] state) {
        int collisions = 0;
        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = i + 1; j < GRID_SIZE; j++) {
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
