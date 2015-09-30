/*
Specifically, suppose there is a line of hutches, stacked to various heights and water is poured
	from the top (and allowed to run off the sides). We'll assume all the hutches are square, have
	side length 1, and for the purposes of this problem we'll pretend that the hutch arrangement is
	two-dimensional.

	For example, suppose the heights of the stacked hutches are [1,4,2,5,1,2,3] (the hutches are
	shown below):

	...X...
	.X.X...
	.X.X..X
	.XXX.XX
	XXXXXXX
	1425123

	When water is poured over the top at all places and allowed to runoff, it will remain trapped at
	the 'O' locations:

	...X...
	.XOX...
	.XOXOOX
	.XXXOXX
	XXXXXXX
	1425123

	The amount of water that has accumulated is the number of Os, which, in this instance, is 5.

	Write a function called answer(heights) which, given the heights of the stacked hutches from
	left-to-right as a list, computes the total area of standing water accumulated when water is
	poured from the top and allowed to run off the sides.

	The heights array will have at least 1 element and at most 9000 elements. Each element will have
	a value of at least 1, and at most 100000.


	Test cases
	==========

	Inputs:
	    (int list) heights = [1, 4, 2, 5, 1, 2, 3]
	Output:
	    (int) 5

	Inputs:
	    (int list) heights = [1, 2, 3, 2, 1]
	Output:
	    (int) 0
 */

 import java.util.List;
 import java.util.ArrayList;

 public class RainCatcher {
 	public int answer(int[] heights) {
 		///1. Find the local maxima.
 		List<Integer> localMaxima = findLocalMaxima(heights);
 		int waterCount = 0;
 		///2. Count the space in between the local maxima, and the expected fill amount of that area
 		for (int i = 0; i < localMaxima.size() - 1; i++) {
 			int minimumHeight = heights[localMaxima.get(i)] < heights[localMaxima.get(i+1)] ? heights[localMaxima.get(i)] : heights[localMaxima.get(i+1)];
 			for (int j = localMaxima.get(i) + 1; j < localMaxima.get(i+1); j++) {
 				///3. If the current fill amount is less than the expected fill amount, add the difference to waterCount
 				if (heights[j] < minimumHeight) {
 					waterCount += minimumHeight - heights[j];
 				}
 			}
 		}
 		///4. Return the count of water.
 		return waterCount;
 	}

 	public List<Integer> findLocalMaxima(int[] heights) {
 		List<Integer> localMaxima = new ArrayList<Integer>();
 		for (int i = 0; i < heights.length; i++) {
 			if (localMaxima.isEmpty()) {
 				//The list of maxima is empty
 				if (i == heights.length - 1) { //Account for the final number being the local maximum
 					localMaxima.add(i);
 				}
 				else if (heights[i] > heights[i+1]) { //First local maximum
 					localMaxima.add(i);
 				}
 			} else if (i == heights.length - 1 && heights[i] > heights[i-1]) {
 					//We have found a potential maximum by virtue of being higher than the previous local maximum
 					localMaxima.add(i);
 			} else if (heights[i] > heights[i-1] && heights[i] == localMaxima.get(localMaxima.size() - 1)) {
 					localMaxima.add(i);
 				}
 			else if (heights[i] > heights[i-1] && heights[i] > heights[i+1]) {
 				//Remove previous maxima that were rendered invalid by this one.
 				for (int j = localMaxima.size() - 1; j > 0; j--) {
 					if (heights[localMaxima.get(j)] < heights[i] && heights[localMaxima.get(j - 1)] > heights[localMaxima.get(j)]) {
 						localMaxima.remove(j);
 					}
 				}
 				localMaxima.add(i);
 			}
 		}
 		return localMaxima;
 	}
 }
