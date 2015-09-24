import java.util.ArrayList;

public class Answer {
  /*Problem 3. Not listed in the original assignment, but I wanted to do this first to help me get
    in the swing of solving the problem. The idea is to print all valid solutions to this problem.

    Solve Time: 22 minutes.
   */
  final int GRID_SIZE = 8; //8 Queens, but could similarly be an N-queens prob.

  public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
    if (row == GRID_SIZE) {
      results.add(columns.clone());
    } else {
      for (int col = 0; col < GRID_SIZE; col++) {
        if (checkValid(columns, row, col)) {
          columns[row] = col;
          placeQueens(row + 1, columns, results);
        }
      }
    }
  }
  boolean checkValid(Integer[] columns, int row1, int column1) {
    for (int row2 = 0; row2 < row1; row2++) {
      int column2 = columns[row2];
      if (column1 == column2)
        return false;

      int columnDistance = Math.abs(column2 - column1);
      int rowDistance = row1 - row2;
      if (columnDistance == rowDistance)
        return false;
    }
    return true;
  }

  /*Problem 1.
    Genetic Algorithm approach.
   */

}
