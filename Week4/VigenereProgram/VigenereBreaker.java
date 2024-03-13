import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public static String Source = "dictionaries";
    public HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
    
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
         StringBuilder slicing = new StringBuilder(message);
        String result = new String();
        for(int k = whichSlice;k<slicing.length();k+=totalSlices){
            result += slicing.charAt(k);
        }
        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker CaesarCracker = new CaesarCracker(mostCommon);
        int aKey;
        int[] key = new int[klength];
        for(int k =0;k<klength;k++) {
           aKey = CaesarCracker.getKey(sliceString(encrypted,k,klength));
           key[k] = aKey;
           //k+=1;
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource resource = new FileResource();
        String message = resource.asString();
        int[] applykey = tryKeyLength(message,4,'e');
        VigenereCipher vignere = new VigenereCipher(applykey);
         System.out.println(vignere.decrypt(message));
        
        
        
    }
    
}
