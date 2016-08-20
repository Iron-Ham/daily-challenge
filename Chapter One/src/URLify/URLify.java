package URLify;

/**
 * Created by heshamsalman on 8/20/16.
 */
public class URLify {

    String URLify(char[] charArray, int trueLength) {
        // `trueLength` - 1 && `charArray.length` - 1 to avoid the OBOE
        trueLength--;
        for(int i = charArray.length - 1; trueLength > 0 && i > 0; i--, trueLength--) {
            if (charArray[trueLength] == ' ') {
                charArray[i] = '0';
                charArray[--i] = '2';
                charArray[--i] = '%';
            } else {
                charArray[i] = charArray[trueLength];
            }
        }
        return new String(charArray);
    }
}
