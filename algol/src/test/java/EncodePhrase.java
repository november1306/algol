import org.testng.annotations.Test;

public class EncodePhrase {

    @Test
    public void EncodeTest() {
        String phrase = "You Shall Not Pass 19";
        String encPhrase;
        int salt = 0x3;

        encPhrase = new String(encodePhrase(phrase, salt, true));
        System.out.println(encPhrase);
        String decPhrase =  new String(encodePhrase(encPhrase, salt, false));
        System.out.println(decPhrase);
    }

    private char[] encodePhrase(String phrase, int salt, boolean encode) {
        char[] chPhrase;
        char[] encChPhrase;
        char encCh = '*';
        int counter = 0;
        chPhrase = phrase.toCharArray();
        encChPhrase = new char[chPhrase.length];

        for (char ch : chPhrase) {
            if (ch == ' ')
                encCh = ch;
            if ('0' <= ch && ch <= '9') {
                int i = Character.getNumericValue(ch);
                if (encode)
                    encCh = Character.forDigit((i + salt) % 10, 10);
                if (!encode)
                    encCh = Character.forDigit((i - salt + 10) % 10, 10);
            }
            if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
                int i = (int) ch;
                if (encode)
                    encCh = (char) (i + salt);
                if (!encode)
                    encCh = (char) (i - salt);
            }
            encChPhrase[counter] = encCh;
            counter++;
        }

        return encChPhrase;
    }
}
