/**
 * Created by heshamsalman on 9/27/15.
 */

import java.util.Random;

class SimulatedAnnealing {
    private final int GRID_SIZE = 8;
    private final int MAX_COLLISIONS = calculateMaxCollisions();
    private final int MAX_ITERATIONS = -1;
    private final Random rand = new Random();
    private final double INITIAL_TEMP = 35;

    int[] simulatedAnnealing() {
        int[] currentState = generateInitialState();
        int iter = 0;
        double temp = INITIAL_TEMP;
        while (MAX_ITERATIONS == -1 || iter < MAX_ITERATIONS) {
            temp = scheduleAnnealing(temp);
            double currentStateFitness = calculateStateFitness(currentState);
            
            if (currentStateFitness == 1.0) return currentState;
            
            int[] nextState = generateNeighborState(currentState);
            double nextStateFitness = calculateStateFitness(nextState);
            double delta = nextStateFitness - currentStateFitness;
            if (delta > 0)
                currentState = nextState;
            else if (rand.nextDouble() <= probabilityOfAcceptance(delta, temp))
                currentState = nextState;
                
            iter++;
        }
        return currentState;
    }

    /* Geometric function. Alt. can be a logarithmic function*/
    private double scheduleAnnealing(double currentTemp) {
        return currentTemp * 0.97;
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

    double calculateStateFitness(int[] state) {
        int collisions = 0;
        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = i + 1; j < GRID_SIZE; j++) {
                if ((state[i] == state[j]) || j - i == Math.abs(state[i] - state[j]))
                    collisions++;
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
