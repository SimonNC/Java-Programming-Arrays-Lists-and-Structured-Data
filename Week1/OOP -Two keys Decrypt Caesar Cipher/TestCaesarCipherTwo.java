
/**
 * Décrivez votre classe TestCaesarCipherTwo ici.
 *
 * @author (Simon JORITE)
 * @version (1.0)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
   public void simpleTests(){
       FileResource f = new FileResource();
       String fAsString = f.asString();
       CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
       String fEncryptedTwo = cc.encrypt(fAsString);
       System.out.println("Encrypted message = " + fEncryptedTwo);
       String fDecryptedTwo = cc.decrypt(fEncryptedTwo);
       System.out.println("Decrypted message = " + fDecryptedTwo);
    }
}
