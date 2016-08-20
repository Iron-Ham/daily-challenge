package IsUnique;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by heshamsalman on 8/19/16.
 */
public class IsUnique {

    /**
     * isUnique
     * With additional data structures
     * @param string the input string
     * @return a boolean value indicating whether the input string has all unique characters
     */
    boolean isUnique(String string) {
        final int MAXIMUM_SIZE = 256; // Or whatever -- ASCII? ExASCII? Unicode?
        Set<Character> characterSet = new HashSet<>();

        if (string.length() > MAXIMUM_SIZE)
            return false;

        for (Character c : string.toCharArray()) {
            if (characterSet.contains(c))
                return false;
            else
                characterSet.add(c);
        }
        return true;
    }

}
