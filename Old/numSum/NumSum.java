/* Given a long input, sum all of its digits, and then if its sum is greater than 10, repeat the process.

The input, x, will be 0 or greater, and less than 2^31.
The output must be a single integer digit. 
 */


import java.util.Scanner;

public class NumSum {

	public static void main(String[] args) {
		System.out.println("Enter value");
		Scanner stdin = new Scanner(System.in);
		System.out.println(answer(stdin.nextLong()));
	}

	public static int answer(long x) {
		int intermediateSum = 0;
		while (x > 0) {
			int tmpValue = (int) (x % 10);
			System.out.println(tmpValue);
			intermediateSum += tmpValue;
			System.out.println("intermediate sum is " + intermediateSum);
			x /= 10;
		}
		int finalSum = 0;
		while (intermediateSum > 0) {
			int tmpValue = (int) (x % 10);
			finalSum += tmpValue;
			System.out.println("Final sum is " + finalSum);
			intermediateSum /= 10;
		}
		return finalSum;
	}
}
