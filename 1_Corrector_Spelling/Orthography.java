import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Orthography {
    
        
    public static void main(String[] args) {
        
        Corrector.spelling();

    } 
}

class Corrector{
    
    static String[] wordList = {"a","ability","able","about","above","accept","according","account","across","act","action","activity","actually","add","address", 
        "administration","admit","adult","affect","after","again","against","age","agency","agent","ago","agree","agreement","ahead","air","all","allow",
        "almost","alone","along","already","also","although","always","American","among","amount","analysis","and","animal","another","answer","any",
        "anyone","anything","appear","apply","approach","area","argue","arm","around","arrive","art","article","artist","as","ask","assume","at","attack","attention","attorney",
        "audience","author","authority","available","avoid","android","away"}; 
    
    public static void spelling(){
        
        
        List<String> wordList2 = Arrays.asList(wordList); // create List of the string array.
        
        Scanner reader = new Scanner(System.in);
        System.out.printf("Type a word: ");
        String word = reader.nextLine();
        

        if(wordList2.contains(word)) System.out.println("Word is spelled correctly.");
        else {
            System.out.println("Word is not spelled correctly.");
            
            int compare = 0;
            int max = -10000;
            int aux,hasEveryLetter;
            String strAux = null;
            String save = null;      
            
            word = word.toLowerCase(); // doesn't matter capital letters
            
            for( String str : wordList ){
                save = str;
                aux = 0;
                hasEveryLetter = 0;
                for( int i = 0; i < word.length() ; i++){          
                    if(containChar((word.charAt(i)),str)){

                        compare += 1;  
                        hasEveryLetter += 1;     // have all letters...
                        
                        if( word.length() == save.length()){ // case: same length
                            if( aux == 0){
                                 compare += 1; // always same length will have priority .
                                 aux = 1;
                            }
                           
                            if( word.charAt(i) == save.charAt(i)) compare += 1;  // and coincidence in same position             
                        }
                        

                        if( word.length() < save.length()){ // case: word less length than word analyzed
                            if( word.charAt(i) == save.charAt(i+(save.length()-word.length()))) compare += 1; // by right
                            if( word.charAt(i) == save.charAt(i)) compare += 1; // by left
                        }
                        
                        if( word.length() > save.length()){ // case: word more length than word analyzed
                            if(i < save.length()){ // not to exceed the smallest word index 
                                if( word.charAt(i+(word.length()-save.length())) == save.charAt(i)) compare += 1; // by right
                                if( word.charAt(i) == save.charAt(i)) compare += 1; // by left
                            }
                        }                   
                        str = deleteChar(str,word.charAt(i)); // not repeat coincidences.
                        //System.out.println(str+" "+compare); // to analyze this code.
                    }
                }
                if(hasEveryLetter == save.length()) compare += 1;
                if( compare > max){
                    max = compare;
                    strAux = save;
                }
                compare = 0;
   
            }
            
            // if the word suggested doesn't have sense.
            // The suggested word and the max number that a word could obtain (suggested word is the correct) have a difference no less than 5
            if( Math.abs(max-(2*strAux.length()+1)) < 5)System.out.println("Did you mean \""+strAux+"\" ?");
            else System.out.println("No suggestion"); 
        }
            reader.close(); 
    }
    
    // Verify if a specified char appear in a string.
    private static boolean containChar(char a, String b){
        for(int i = 0; i<b.length(); i++){
            if(b.charAt(i)==a) return true;
        }
        return false;
    }
    
    // Delete the first apparition of a specified char in a string.
    private static String deleteChar(String a, char b){
        int index = 0;
        String result = null;
        for(int i = 0; i<a.length(); i++){
            
            if(a.charAt(i)==b) {
                index = i;
                i = a.length()+1; // delete first coincidence 
            }
        }
        result = a.substring(0, index) + a.substring(index+1,a.length());
        return result;
    }
    
}

