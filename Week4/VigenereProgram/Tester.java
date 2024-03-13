
/**
 * Décrivez votre classe Tester ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.*;
import edu.duke.*;
import java.lang.*;
import java.io.*;

public class Tester {
    public void testCaesarCipher(){
        CaesarCipher cc = new CaesarCipher(5);
        FileResource fr = new FileResource("data/titus-small.txt");
        String message = fr.asString();
        String encrypted =  cc.encrypt(message);
        System.out.println("The encryption result is " +encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("The decryption outcome is "+decrypted);
              
    }
    
    public void testCaesarCracker(){
        CaesarCracker cc = new CaesarCracker('a');
        FileResource fr = new FileResource("data/oslusiadas_key17.txt");
        String encrypted = fr.asString();
        String decrypted = cc.decrypt(encrypted);
        System.out.println("The decryption outcome is "+decrypted);
        
        
        
    }
    
    public void testVigenereCipher(){
        int Vigenerekey[] = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(Vigenerekey);
        FileResource fr = new FileResource("data/titus-small.txt");
        String message  = fr.asString();
        String encrypted =  vc.encrypt(message);
        System.out.println("The Vigenere encryption result is " +encrypted);
        String decrypted = vc.decrypt(encrypted);
        System.out.println("The Vigenere decryption outcome is "+decrypted);
        
        
        
        
    }
    
    public void testVigenereBreaker(){
        //VigenereBreaker vb = new VigenereBreaker();
        //String test = vb.sliceString("abcdefghijklm", 1, 3);
        //System.out.println(test);
        VigenereBreaker VB = new VigenereBreaker();
        //FileResource fr = new FileResource("data/athens_keyflute.txt");
        FileResource fr = new FileResource();
        String message  = fr.asString();
        int keyReturn[] = new int[4];
        keyReturn = VB.tryKeyLength(message,4,'e');
        for (int i =0 ;i < keyReturn.length;i+=1){
            System.out.println("Return Keys "+ keyReturn[i] + "\t");
        }
    
        
        
    }
    
}
