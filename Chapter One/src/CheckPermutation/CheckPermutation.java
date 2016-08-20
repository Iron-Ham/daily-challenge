package CheckPermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class CheckPermutation {
    // With Mapping
    boolean isPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;

        Map<Character, Integer> aMap = generateMapping(a);
        Map<Character, Integer> bMap = generateMapping(b);

        return bMap.equals(aMap);
    }

    Map<Character, Integer> generateMapping(String fromString) {
        Map<Character, Integer> mapping = new HashMap<>();
        for (Character c : fromString.toLowerCase().toCharArray()) {
            int newValue = mapping.containsKey(c) ? mapping.get(c) + 1 : 1;
            mapping.put(c, newValue);
        }
        return mapping;
    }

    boolean isPermuationThroughSort(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        java.util.Arrays.sort(aArray);
        java.util.Arrays.sort(bArray);
        a = new String(aArray);
        b = new String(bArray);
        return a.equals(b);
    }

    boolean isPermutationThroughIntMapping(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] intArray = new int[256]; //ExASCII
        for (char c : a.toCharArray()) {
            intArray[c]++;
        }

        for (char c : b.toCharArray()) {
            intArray[c]--;
            if (intArray[c] < 0)
                return false;
        }

        return true;
    }

}
