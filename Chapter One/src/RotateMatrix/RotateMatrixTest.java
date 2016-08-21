package RotateMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class RotateMatrixTest {

    RotateMatrix rM = new RotateMatrix();

    @Test
    public void matrixRotation_2x2() {
        int[][] inputMatrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expectedMatrix = {
                {3, 1},
                {4, 2}
        };

        int[][] actualMatrix = rM.matrixRotation(inputMatrix);
        assertEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void matrixRotation_4x4() {
        int[][] inputMatrix = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] expectedMatrix= {
                {13,  9,  5,  1},
                {14, 10,  6,  2},
                {15, 11,  7,  3},
                {16, 12,  8,  4}
        };

        int[][] actualMatrix = rM.matrixRotation(inputMatrix);
        assertEquals(expectedMatrix, actualMatrix);
    }

}