package StringCompression;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class StringCompression {
    String compress(String s) {

        StringBuilder sb = new StringBuilder();
        char previousChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (previousChar == currentChar) {
                count++;
            }

            if (previousChar != currentChar || i == s.length() - 1){
                sb.append(previousChar);
                sb.append(count);
                count = 1;
                previousChar = currentChar;
            }
        }
        String compressedString = sb.toString();
        return compressedString.length() < s.length() ? compressedString : s;
    }
}
