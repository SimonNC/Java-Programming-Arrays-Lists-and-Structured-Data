
/**
 * Décrivez votre classe CharactersInPlay ici.
 *
 * @author (Simon JORITE)
 * @version (1.0)
 */

import edu.duke.*;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;


public class CharactersInPlay {
    private ArrayList<String> character_name;
    private ArrayList<Integer> count;
    
    public CharactersInPlay(){
        character_name = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    public void update(String person){
        int index = character_name.indexOf(person);
        if(index == -1){
            character_name.add(person);
            count.add(1);
        } else {
            int freq = count.get(index);
            count.set(index,freq+1);
        }
    }
    public void findAllCharacters(){
        //clear ArrayLists first
        character_name.clear();
        count.clear();
        //open a file for reading line-by-line
        FileResource fileResource = new FileResource();
        //for each line
        for(String line: fileResource.lines()){
            int periodInLine = line.indexOf(".");
            if(periodInLine != -1){
                String possibleName = line.substring(0,periodInLine);
                update(possibleName);
            }
        }        
        
        
    }
    public void tester (){
        findAllCharacters();
               
        for (int k =0; k < count.size();k++) {
           
            if (count.get(k) > 1) {
            
             System.out.println("The main character is: "+ character_name.get(k) +"\t"
             +"The number of speaking parts is: "+ count.get(k));
             
            }
            
        }
       int num1 = 2;
       int num2 = 3;
       charactersWithNumParts(num1, num2);
            
    }
    
        public void charactersWithNumParts(int num1, int num2) {
        
        for (int k =0; k < count.size();k++) {
           
            if (count.get(k) >= num1 && count.get(k)<= num2) {
            
                System.out.println("The main character between : " + num1 + " and " + num2 
                + " is " + character_name.get(k) +"\t"
                +"The number of speaking parts is: "+ count.get(k));
             
            }
            
        }
    
    }
}
