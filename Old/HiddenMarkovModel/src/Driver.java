/**
 * Created by heshamsalman on 11/15/15.
 */
public class Driver {
    public static void main(String[] args) {

        if (args.length == 0) {
            HiddenMarkovModel hmm = new HiddenMarkovModel();
        } else if (args.length == 1) {
            // Allows for custom testing data
            HiddenMarkovModel hmm = new HiddenMarkovModel(args[0]);
        } else if (args.length == 2) {
            // Custom training and testing data
            HiddenMarkovModel hmm = new HiddenMarkovModel(args[0], args[1]);
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Too many arguments!");
        System.out.println("Usage:");
        System.out.println("With custom testing data: java Driver /path/to/testing/data");
        System.out.println("With default parameters: java Driver");
        System.out.println("With custom testing and training data: java Driver /path/to/training path/to/testing");
        System.exit(1);
    }
}
