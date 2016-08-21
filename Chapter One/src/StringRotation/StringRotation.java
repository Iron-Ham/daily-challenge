package StringRotation;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class StringRotation {
    boolean isSubstring(String s, String ofString) {
        if (s.length() > ofString.length())
            return false;
        s = s.toLowerCase();
        ofString = ofString.toLowerCase();
        return ofString.contains(s);
    }

    boolean isRotation(String s, String ofString) {
        if (s.length() != ofString.length())
            return false;
        ofString += ofString;
        if (isSubstring(s, ofString))
            return true;
        return false;
    }
}
