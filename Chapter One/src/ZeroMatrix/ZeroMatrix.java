package ZeroMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class ZeroMatrix {

    class Point {
        int outer; // int[]
        int inner; // int[][]

        Point(int outer, int inner) {
            this.outer = outer;
            this.inner = inner;
        }
    }

    int[][] zeroMatrix(int[][] matrix) {
        List<Point> pointList = findPoints(matrix);

        for (Point p : pointList) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][p.inner] = 0;

            for (int i = 0; i < matrix[0].length; i++)
                matrix[p.outer][i] = 0;
        }
        return matrix;
    }

    List<Point> findPoints(int[][] matrix) {
        List<Point> pointList = new ArrayList<ZeroMatrix.Point>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] == 0)
                    pointList.add(new Point(i, j));
        return pointList;
    }
}
