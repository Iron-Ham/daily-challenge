package OneAway;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class OneAway {
    boolean oneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0, j = i; i < a.length(); i++, j++) {
            if (a.charAt(i) == b.charAt(j))
                continue;

            diffCount++;
            if (a.length() > b.length())
                j--;
            else if (a.length() < b.length())
                i--;

            if (diffCount > 1)
                return false;
        }
        return true;
    }
}
