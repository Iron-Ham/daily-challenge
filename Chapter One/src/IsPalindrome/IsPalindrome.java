package IsPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class IsPalindrome {
    // Check to see if it is a permutation of a palindrome
    boolean isPalindrome(String s) {
        // Even count strings, all characters must have an even count
        // Odd count strings must have all even characters except for one.

        // We can map the characters, and then deal with the counts later.
        s = s.toLowerCase();
        // We can skip this step of creating the map if we know what characters are valid --
        // ASCII, ExAscii, unicode can just initialize an array of size MAX
        // And then immediately start updating the counts at the values of `char_value`
        Map<Character, Integer> characterCount = new HashMap<>();
        for (Character c : s.toCharArray()) {
            int newValue = characterCount.containsKey(c) ? characterCount.get(c) + 1 : 1;
            characterCount.put(c, newValue);
        }

        // Take a look at the resulting value mapping.
        Integer[] characterValues = characterCount.values().toArray(new Integer[0]);
        int oddCount = 0;

        for (Integer i : characterValues) {
            if (i % 2 != 0)
                oddCount++;

            if ((s.length() % 2 == 0 && oddCount > 0) || (s.length() % 2 != 0 && oddCount > 1)) {
                return false;
            }
        }
        return true;
    }
}
