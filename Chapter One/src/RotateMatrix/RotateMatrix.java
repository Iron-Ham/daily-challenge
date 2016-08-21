package RotateMatrix;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class RotateMatrix {
    int[][] matrixRotation(int[][] matrix) {
        // Can't rotate a non-uniform matrix
        // Can't rotate an empty matrix
        if (matrix.length != matrix[0].length || matrix.length == 0) return matrix;

        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int start = layer;
            int end = matrix.length - 1 - layer;

            for (int i = start; i < end; i++) {

                int offset = i - layer;
                // Save first position
                int top = matrix[start][i];

                // Left -> Top
                matrix[start][i] = matrix[end - offset][start];

                // Bottom -> Left
                matrix[end - offset][start] = matrix[end][end - offset];

                // Right -> Bottom
                matrix[end][end - offset] = matrix[i][end];

                // Top -> Right

                matrix[i][end] = top;
            }
        }
        return matrix;
    }
}
