import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class RandomTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * A line to test Github
 */
public class RandomTester
{
    // instance variables - replace the example below with your own
    private Random random;
    private ArrayList<String> responseList;
    
    /**
     * Constructor for objects of class RandomTester
     */
    public RandomTester()
    {
        // initialise instance variables
        random = new Random();
        responseList = new ArrayList<String>();
    }

    /**
     *
     */
    public void printOneRandom(int upperLimit)
    {
        random = new Random();
        int randomInt = random.nextInt(upperLimit);
        System.out.println(randomInt);
    }

    /**
     *
     */
    public void printMultiRandom(int upperLimit, int howMany)
    {
        int index = 0;
        while(index < howMany) {
            random = new Random();
            int randomInt = random.nextInt(upperLimit);
            System.out.println(randomInt); 
            index++;
        } 
    }
    
    /**
     *
     */
    public void throwDice()
    {
        int randomInt = random.nextInt(6);
        randomInt++;
        System.out.println(randomInt);
    }
    
    /**
     *
     */
    public void getResponse()
    {
        int totalResponses = responseList.size();
        int randomInt = random.nextInt(totalResponses);
        String response = responseList.get(randomInt);
        System.out.println(response);
    }
        /**
     *
     */
    public void addToResponseArray(String addResponse)
    {
        responseList.add(addResponse);
    }
}
