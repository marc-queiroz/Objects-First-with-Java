
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeAppointment(int day,int time,int duration,String description)
    {
        // put your code here
        
        Day createdDay = new Day(day);
        Appointment appointment = new Appointment(description,duration);
        
        createdDay.makeAppointment(time,appointment);
        createdDay.showAppointments();
        
    }
}
