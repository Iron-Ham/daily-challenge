package ZeroMatrix;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class ZeroMatrixTest {

    ZeroMatrix zM = new ZeroMatrix();

    @Test
    public void zeroMatrix_WhereSomethingToZero_2x2() {
        int[][] matrix = {
                {1, 1},
                {0, 1}
        };

        int[][] expectedMatrix = {
                {0, 1},
                {0, 0}
        };

        int[][] actualMatrix = zM.zeroMatrix(matrix);
        assertEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void zeroMatrix_WhereSomethingToZero_4x4() {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        int[][] expectedMatrix = {
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] actualMatrix = zM.zeroMatrix(matrix);
        assertEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void zeroMatrix_WhereNothingToZero() {

    }

    @Test
    public void findPoints_WhereNoPoints() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        List<ZeroMatrix.Point> pointList = zM.findPoints(matrix);
        int expectedSize = 0;
        int actualSize = pointList.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void findPoints_WherePoints() {
        int[][] matrix = {
                {1, 0},
                {0, 1}
        };
        List<ZeroMatrix.Point> pointList = zM.findPoints(matrix);
        int expectedSize = 2;
        int actualSize = pointList.size();
        assertEquals(expectedSize, actualSize);
    }

}