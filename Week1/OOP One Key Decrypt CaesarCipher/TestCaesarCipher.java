
/**
 * Décrivez votre classe TestCaesarCipher ici.
 *
 * @author (Simon JORITE)
 * @version (1.0)
 */
import edu.duke.*;

public class TestCaesarCipher {
        int[] countLetters(String message) {
       //This method counts the number of occurences of every letter of the alphabet in a given sentence "message" 
       String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i=0; i < message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
       public int maxIndex(int[] vals){
        /*This method takes the number that each caracter occurs (freqs),compares them and returns the 
         * int which is the number of the character (the index of the character) most repeated. 
         */
        int maxDex = 0;
        for(int i=0; i < vals.length; i++){
            if (vals[i] > vals[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
     }
        public void simpleTests(){
       FileResource f = new FileResource();
       String fAsString = f.asString();
       CaesarCipher cc = new CaesarCipher(18);
       String fEncrypted = cc.encrypt(fAsString);
       System.out.println("Encrypted message = " + fEncrypted);
       String fDecrypted = cc.decrypt(fEncrypted);
       System.out.println("Decrypted message = " + fDecrypted);
       String breakCaesarCipher = breakCaesarCipher(fEncrypted);
       System.out.println("The decryption outcome is "+ breakCaesarCipher);
       
       /*cc = new CaesarCipher(INSERT KEY HERE);
       String fEncrypted = cc.encrypt(fAsString);
       System.out.println("Encrypted message = " + fEncrypted);
       String fDecrypted = cc.decrypt(fEncrypted);
       System.out.println("Decrypted message = " + fDecrypted);*/
    }
    
    public String breakCaesarCipher(String input) {
    
    int [] freqs = countLetters(input);
    int maxDex = maxIndex(freqs);
    int dkey = maxDex - 4;
    if (dkey < 0)
    { dkey = 26 - (4 - maxDex);}
    CaesarCipher cc = new CaesarCipher(dkey);
    //return dkey;
    String message = cc.decrypt(input);
    return message;
}
     
}
