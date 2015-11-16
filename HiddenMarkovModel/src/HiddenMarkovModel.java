import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by heshamsalman on 11/15/15.
 */
public class HiddenMarkovModel {
    private final int numberOfStates = 26;
    private final double[] priorProbability = new double[numberOfStates];
    private final int[] outputCount = new int[numberOfStates];
    private final double[][] emissions = new double[numberOfStates][numberOfStates]; // The probability of any one output occurring given a state
    private final int[][] emissionsCount = new int[numberOfStates][numberOfStates];
    private final int[][] transitionsCount = new int[numberOfStates][numberOfStates];
    private final double[][] transitions = new double[numberOfStates][numberOfStates];

    HiddenMarkovModel(String testingData) {
        trainModel();
        testHMM(testingData);
    }

    HiddenMarkovModel(String trainingData, String testingData) {
        trainModel(trainingData);
        testHMM(testingData);
    }

    HiddenMarkovModel() {
        trainModel();
        testHMM();
    }

    // Assumes the same file structure as the training data
    private void testHMM(String filePath) {
        PrintWriter pw = null;
        Scanner fileReader = null;

        try {
            pw = new PrintWriter(new File("HMM_OUTPUT.TXT"));
            fileReader = new Scanner(new File(filePath));

            char previousState = '_';
            double[] prevProb = new double[numberOfStates]; // Keeps track of previous state probability
            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine().trim();
                String[] lineComponents = currentLine.split("\\s+");

                char output = lineComponents[1].charAt(0);

                // End of word
                if (output == '_') {
                    previousState = '_';
                    pw.println(output);
                    continue;
                }

                // Start of word
                if (previousState == '_') {
                    // Start = P_start(state) * P_obs(observation)
                    for (int i = 0; i < prevProb.length; i++) {
                        prevProb[i] = Math.log(priorProbability[i]) + Math.log(emissions[i][getCharValue(output)]);
                    }
                } else {
                    /* These two nested for loops could probably be reduced into one loop */

                    // S(i) = P(oldState) * P_trans(old -> new) * P(observation|new)
                    double[][] tmp = new double[numberOfStates][numberOfStates];
                    for (int i = 0; i < numberOfStates; i++) {
                        for (int j = 0; j < numberOfStates; j++) {
                            tmp[i][j] = prevProb[i] + Math.log(transitions[i][j]) + Math.log(emissions[j][getCharValue(output)]);
                        }
                    }

                    // Take most likely path of each state
                    for (int i = 0; i < numberOfStates; i++) {
                        int max = 0;
                        for (int j = 1; j < numberOfStates; j++) {
                            if (tmp[max][i] < tmp[j][i]) {
                                max = j;
                                prevProb[i] = tmp[max][i];
                            }
                        }
                    }
                }

                // Take most likely state path
                int max = 0;
                for (int i = 1; i < prevProb.length; i++) {
                    if (prevProb[i] > prevProb[max]) {
                        max = i;
                    }
                }

                pw.println(getCharFromInt(max));
                previousState = output;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }


    }

    private void testHMM() {
        testHMM("typos20.data");
    }

    private int getCharValue(char c) {
        if (c != '_') {
            return c - 'a';
        }
        return numberOfStates;
    }

    private char getCharFromInt(int i) {
        if (i != numberOfStates) {
            i += 'a';
            return (char) i;
        }
        return '_';
    }

    private void trainModel(String filePath) {
        Scanner fileReader = null;

        char previousState = '_';

        try {
            fileReader = new Scanner(new File(filePath));

            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine().trim();
                String[] lineComponents = currentLine.split("\\s+");

                char currentState = lineComponents[0].charAt(0);
                char output = lineComponents[1].charAt(0);

                // Increment state occurrence counter for calculating prior probabilities
                // Increment emissions counter
                // Increment transitions counter
                if (output != '_' && previousState != '_') {
                    outputCount[getCharValue(currentState)] += 1;
                    emissionsCount[getCharValue(currentState)][getCharValue(output)] += 1;
                    transitionsCount[getCharValue(previousState)][getCharValue(currentState)] += 1;
                }

                previousState = currentState;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            calculatePriorProbability();
            calculateEmissions();
            calculateTransitions();
        }
    }

    private void calculatePriorProbability() {
        int sum = sumOfArray(outputCount);
        for (int i = 0; i < priorProbability.length; i++) {
            priorProbability[i] = (double) outputCount[i] / sum;
        }
    }

    private void calculateEmissions() {
        for (int i = 0; i < emissions.length; i++) {
            int sum = sumOfArray(emissionsCount[i]); // Get the count of state s

            for (int j = 0; j < emissions[i].length; j++) {
                emissions[i][j] = ((double) emissionsCount[i][j] + 1) / (sum + numberOfStates); // Smooth probability
            }
        }
    }

    private void calculateTransitions() {
        for (int i = 0; i < transitions.length; i++) {
            int sum = sumOfArray(transitionsCount[i]); // Get the count of state s

            for (int j = 0; j < transitions[i].length; j++) {
                transitions[i][j] = ((double) transitionsCount[i][j] + 1) / (sum + numberOfStates); // Smooth probability
            }
        }
    }

    private void trainModel() {
        trainModel("typos20.data");
    }

    private int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}