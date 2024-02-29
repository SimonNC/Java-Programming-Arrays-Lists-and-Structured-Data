
/**
 * Décrivez votre classe WordPlay ici.
 *
 * @author (Simon JORITE)
 * @version (0.1)
 */
public class WordPlay {
    private boolean isVowel(char ch){
        char lower = Character.toLowerCase(ch);
         if ( (lower=='a') || (lower=='e') || (lower=='i') || (lower=='o') || (lower=='u'))
            return true;
        
        return false;
    }
    public void test_isVowel(){
    char test1 = 'e';
    char test2 ='a';
    char test3 = 'B';
    System.out.println("Is " +test1 + " vowel " + isVowel(test1));
    System.out.println("Is " +test2 + " vowel " + isVowel(test2));
    System.out.println("Is " +test3 + " vowel " + isVowel(test3));
}
    public String replaceVowels(String phrase,char ch){
       String newString ="";
       for(int i =0;i < phrase.length();i++){
           char currChar = phrase.charAt(i);
           if(isVowel(currChar)) {
               newString =newString + ch;
           } else {
               newString = newString + currChar;
           }
               
       }
       return newString;
    }
        public void test_replaceVowels(){
    System.out.println("Hello World" + " " + replaceVowels("HELLO World",'*'));    
    }
      public boolean isEven(int n){
        if ((n % 2) == 0) return true; else return false;
        
    }
      public String emphasize(String phrase, char ch){
        String newString ="";
        for (int i=0; i<phrase.length();i++){
              
            char currChar = phrase.charAt(i);

            if (Character.toLowerCase(currChar)==ch) {
               if (isEven(i+1)) newString=newString + "+";
               else newString=newString + "*";
               }
               else newString=newString + currChar;
        }
        return newString;
        
    }
     public void test_emphasize(){
        String test1 = "dna ctgaaactga";
        String test2 = "Mary Bella Abracadabra";
        System.out.println(test1);
        System.out.println(emphasize(test1,'a'));
        System.out.println(test2);
        System.out.println(emphasize(test2,'a'));
    }
}
