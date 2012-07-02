import java.util.StringTokenizer;
import java.util.HashSet;
/**
 * Write a description of class TokenizerTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TokenizerTest
{
    // instance variables - replace the example below with your own
    String text;

    /**
     * Constructor for objects of class TokenizerTest
     */
    public TokenizerTest()
    {

}

    public void split(String text)
    {
        // initialise instance variables
        StringTokenizer tokenizer = new StringTokenizer(text);
        System.out.print("> ");
        
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        
    }
}
}
