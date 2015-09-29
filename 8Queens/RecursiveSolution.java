/*
 Generates the complete set of valid answers. May be useful for testing.

 ways to arrange 8 queens on an 8x8 board =
   ways to arrange 8 queens on an 8x8 board with queen at (7,0)
   ways to arrange 8 queens on an 8x8 board with queen at (7, 1)
   ways to ... with queen at (7, 2)
   ways to ... with queen at (7, 3)
   ways to ... with queen at (7, 4)
   ways to ... with queen at (7, 5)
   ways to ... with queen at (7, 6)
   ways to ... with queen at (7, 7)
   = 8 branches

   Each one of these "branches" can be computed by calculating:
     ways to ... with queen at (7, 2)  =
       ways to ... with queen at (7, 2)  and (6, 0)
       ways to ... with queen at (7, 2)  and (6, 4)
       ways to ... with queen at (7, 2)  and (6, 5)
       ways to ... with queen at (7, 2)  and (6, 6)
       ways to ... with queen at (7, 2)  and (6, 7)
       = 5 branches
       (We don't need to check the other 3 possibilities, because it would violate the
       solution constraints)

       etc...

       If we follow this out, we'll see that the branches decrease pretty quickly. The next iterations for some of
       these branch as few as 3->1->1->0 or 3->3->1...->1.

 If I had to state the general time-space complexity, perhaps O(n * n^b), where n = # of queens
 and b = the average branching factor. The n^b is pretty self explanatory -- that's the measure
 of the recursive call stack. The initial n is the amount of work done in each call.

 Once we follow this logic, we'll see that it must return an answer, and it's actually pretty
 straightforward to implement.
*/

import java.util.List;

class RecursiveSolution {
  private final int GRID_SIZE = 8; //8 Queens but could be an N-queens prob. Fitness function will auto-magically adjust
   //Does not include mirror image solutions. (i.e., 42061753 is not distinct from 35716024)
   void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
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

   void placeQueensWithDuplicates(int row, Integer[] columns, List<Integer[]> results) {
       if (row == GRID_SIZE) {
           results.add(columns.clone());
           Integer[] reverseSolution = new Integer[GRID_SIZE];
           for (int i = 0; i < GRID_SIZE; i++) {
               reverseSolution[i] = columns[columns.length - i - 1];
           }
           results.add(reverseSolution);
       } else {
           for (int col = 0; col < GRID_SIZE; col++) {
               if (checkValid(columns, row, col)) {
                   columns[row] = col;
                   placeQueensWithDuplicates(row + 1, columns, results);
               }
           }
       }
   }

   private boolean checkValid(Integer[] columns, int row1, int column1) {
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
}
