/*

You must select the name with the largest value.
If you assign 1 to the letter a, 2 to be, etc..., and add up the values for all the letters
the names with the highest total values will be the best.

So given a list of names, return the list sorted in descending order of value.

There will be at least 1 and no more than 1000 names. Each name will consist only of lowercase
letters. The length of each name will be at least one and no more than eight.

Test cases
==========

Inputs:
    (string list) names = ["annie", "bonnie", "liz"]
Output:
    (string list) ["bonnie", "liz", "annie"]

Inputs:
    (string list) names = ["abcdefg", "vi"]
Output:
    (string list) ["vi", "abcdefg"]

 */

import java.util.Arrays;
import java.util.Collections;

public class WeightedNames {
    public static String[] answer(String[] names) {
		String[] answer = new String[names.length];
		int[] values = getValues(names);
		PossibleName[] possibleNames = getDS(names, values);
		for (int i = 0; i < names.length; i++) {
			answer[i] = possibleNames[i].name;
		}
		return answer;
	}

	static class PossibleName implements Comparable<PossibleName> {
		int value;
		String name;

		public PossibleName(String name, int value) {
			this.value = value;
			this.name = name;
		}

		@Override
		public int compareTo(PossibleName o) {
			if (value > o.value) {
				return 1;
			}
			else if (value < o.value) {
				return -1;
			}
			else {
				for (int i = 0; i < name.length(); i++) {
					if (name.charAt(i) > o.name.charAt(i)) {
						return 1;
					}
					else if (name.charAt(i) < o.name.charAt(i)) {
						return -1;
					}
					else {
						continue;
					}
				}
			}
			return 0;
		}
	}

	public static PossibleName[] getDS(String[] names, int[] values) {
		PossibleName[] possibleNames = new PossibleName[names.length];
		for (int i = 0; i < names.length; i ++) {
			possibleNames[i] = new PossibleName(names[i], values[i]);
		}
		Arrays.sort(possibleNames, Collections.reverseOrder());
		return possibleNames;
	}

	public static int[] getValues(String[] names) {
		int[] values = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			char[] nameCharArray = name.toCharArray();
			int sum = 0;
			for (char c : nameCharArray) {
				sum += c - 96;
			}
			values[i] = sum;
		}
		return values;
	}

	public static void main(String[] args) {
		String[] names = {"annie", "bonnie", "liz"};
		String[] answers = answer(names);
		for (String answer : answers) {
			System.out.println(answer);
		}
	}
}
