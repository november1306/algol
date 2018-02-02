import org.testng.annotations.Test;

public class EncodePhrase {
    /*

     */


    @Test
    public void EncodeTest() {
        String phrase = "You Shall Not Pass 19";
        String encPhrase;
        int salt = 0x3;

        encPhrase = new String(  encodePhrase(phrase, salt));
         System.out.println(encPhrase);
    }

    private char[] encodePhrase(String phrase, int salt) {
        char[] chPhrase;
        char[] encChPhrase;
        char encCh ='*';
        int ascii;
        int counter = 0;
        chPhrase = phrase.toCharArray();
        encChPhrase = new char[chPhrase.length];

        for (char ch : chPhrase) {
            if (ch == ' ')
                encCh = ch;
            if ('0' <= ch && ch <= '9') {
                int i = Character.getNumericValue(ch);
                encCh = Character.forDigit((i + salt)%10, 10);
            }
            if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
                int i = (int) ch;
                encCh = (char) (i + salt);
            }

            encChPhrase[counter] = encCh;
            counter++;
        }

        return encChPhrase;
    }
}
