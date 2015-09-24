public class Answer {
  //Approach 1: The easy way.
  /*Sorts the two arrays, compares the sorted output.
    Time efficiency: O(nlogn + mlogm) n = length of s1, m = length of s2
    Space efficiency: O(n + m), where n = length of s1, m = length of s2
    Solve time: 3 minutes.
   */
  public boolean checkPermutation(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    if (sort(s1).equals(sort(s2)))
      return true;
    return false;
  }
  private String sort(String s) {
    char[] c = s.toCharArray();
    java.util.Arrays.sort(c);
    return new String(c);
  }

  //Approach 2: The efficient way
  /*Increments the value of each possible letter in an array. Decrements for the
    second string.
    Time efficiency: O(n + m), where n = length(s1), m = length(s2)
    Space efficiency: O(1)
    Solve time: 8 minutes.
   */
  public boolean checkPermutationEfficiently(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    int[] letters = new int[256]; //128 for std. ascii
    char[] s1_array = s1.toCharArray();
    for (char c : s1_array) {
      letters[c]++;
    }
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      letters[c]--;
      if (letters[c] < 0)
        return false;
    }
    return true;
  }
}
