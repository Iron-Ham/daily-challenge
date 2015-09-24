import java.util.Set;
import java.util.HashSet;
public class IsUnique {

  /*With use of additional data structures
    Time complexity can be argued to be O(1) because the for-loop will never
    run longer than the size of the char-set (128, 256, or whatever UTF-8 is).
    Otherwise, time complexity is O(n), where n is the size of the input string.

    Space Complexity is O(1).
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
   */
  public boolean isUniqueWithoutSet(String s) {
    int check = 0;
    if (s.length() > 256) {
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
}
