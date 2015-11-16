# Hidden Markov Model

This is a generic HMM implementation in Java. It does not require a set of training or testing data, but one can be supplied to it. If testing or training data is supplied, it **must be supplied** in the following format:

    a a
    _ _
    s s
    h n
    o o
    r r
    t t
    _ _
    s a
    t r
    o o
    r r
    y y
    _ _

Where the left column is the expected state and the right hand column is the given output. The model uses the Viterbi algorithm to correct spelling errors. It supplies output in the same format as the input, but in one column.

## Usage

### With No Arguments

    java Driver

Without any arguments, it will train using the training data `typos20.data`, and run the test on the right hand column of the data.

### With One Argument

    java Driver /path/to/testing/data

With one argument, it will train using the training data `typos20.data` and test the HMM using the supplied testing data.

### With Two Arguments

    java Driver /path/to/training/data /path/to/testing/data

With two arguments, it will train using the first argument and test using the second argument.
