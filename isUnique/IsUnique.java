import java.util.Set;
import java.util.HashSet;

public class IsUnique {

  /*With use of additional data structures
    Time complexity can be argued to be O(1) because the for-loop will never
    run longer than the size of the char-set (128, 256, or whatever UTF-8 is).
    Otherwise, time complexity is O(n), where n is the size of the input string.

    Space Complexity is O(1).

    Solve time: 3 minutes
   */
  public boolean isUnique(String s) {
    //ExASCII = 256. Standard ASCII = 128. UTF-8 = ???
    if (s.length() > 256) {
      return false;
    }
    Set<Character> letterSet = new HashSet<Character>();
    for (int i=0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!letterSet.contains(c)) {
        letterSet.add(c);
      } else {
        return false;
      }
    }
    return true;
  }

  /*Without the use of additional data structures
    Uses int as a bit mask.
    Assumption: letters a-z, lowercase only

    Time complexity, again, can be argued to be O(1) for the same reasons.
    If that argument is not accepted, O(n), where n is the size of the input
    string.

    Space Complexity: O(1), but it uses a smaller amount of space than the
    previous solution.

    Solve time: 10 minutes
   */
  public boolean isUniqueWithoutSet(String s) {
    int check = 0;
    if (s.length() > 26) {
      return false;
    }
    for (int i=0; i < s.length(); i++) {
      int val = s.charAt(i) - 'a';
      val = 1 << val;
      if ((check & val) > 0) {
        return false;
      }
      check |= val;
    }
    return true;
  }

  /*Without the use of additonal data structures.
    Sorts the underlying character array of the string, iterates through it and
    compares adjacent characters.

    Time complexity: O(nlogn). Arguably, O(n^2) if the java quick-sort hits its
    worst-case time (highly unlikely).
    Space complexity: Arguably, O(1), because the largest the array will ever be
    is the size of the character set. Otherwise, O(n), where n is the size of
    the input string.

    Solve time: 2 minutes.
   */
  public boolean badSolution(String s) {
    if (s.length() > 26) {
      return false;
    }
    char[] charArray = s.toCharArray();
    java.util.Arrays.sort(charArray);

    for (int i=0, j=i+1; i < charArray.length - 1; i++, j++) {
      if (charArray[i] == charArray[j]) {
        return false;
      }
    }
    return true;
  }

  /*This solution is terri-bad, but it works. Does not require additional data
    structures.

    Time complexity: O(n^2)
    Space complexity: O(1)/O(n).

    Solve time: 2 minutes.
   */
  public boolean worseSolution(String s) {
    if (s.length() > 256) {
      return false;
    }

    for (int i=0; i < s.length() - 1; i++) {
      for (int j=i+1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }

}
