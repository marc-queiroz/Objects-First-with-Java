/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    private int[] weekCounts;
    private int accessCounts200 = 0;
    private int accessCounts403 = 0;
    private int accessCounts404 = 0;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        weekCounts = new int[7];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasMoreEntries()) {
            LogEntry entry = reader.nextEntry();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Analyze the weekly access data from the log file.
     */
    public void analyzeWeeklyData()
    {
        while(reader.hasMoreEntries()) {
            LogEntry entry = reader.nextEntry();
            int day = entry.getDay();
            int dayOfWeek = day % 7;
            weekCounts[dayOfWeek]++;
        }
    }
    
    public void analyzeAccessCounts()
    {
        while(reader.hasMoreEntries()) {
            LogEntry entry = reader.nextEntry();
            int code = entry.getCode();
            if(code == 200){
                accessCounts200++;
            }
            else if(code == 403){
                accessCounts403++;
            }
            else if(code == 404){
                accessCounts404++;
            }
                
        }
    }
    
    public void printAccessCounts()
    {
        System.out.println("200: " + accessCounts200);
        System.out.println("403: " + accessCounts403);
        System.out.println("404: " + accessCounts404);
          
    }
    
    /**
     * Print the weekly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printWeeklyCounts()
    {
        System.out.println("Day of Week: Count");
        for(int dayOfWeek = 1; dayOfWeek < 8; dayOfWeek++) {
            System.out.println(dayOfWeek + ": " + weekCounts[dayOfWeek-1]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    /**
         * Return the number of accesses recorded in the log
         * file.
         */
    public int numberOfAccesses()
    {
            int total = 0;
            // Add the value in each element of hourCounts
            // to total.
            for(int hour = 0; hour < hourCounts.length; hour++) {
            total = total + hourCounts[hour];
            }
            return total;
    }
      
    public int busiestHour()
    {
            int numberOfAccessesAtBusiest = 0;
            int busiestHour = 0;
            int index = 0;
            
            while(index < hourCounts.length - 1){
                if (numberOfAccessesAtBusiest < hourCounts[index]){
                    busiestHour = index;
                    numberOfAccessesAtBusiest = hourCounts[index];
                    index++;
                }
                else {
                    index++;
                }
            }
            return busiestHour;
    }
    
    public int quietestHour()
    {
            int numberOfAccessesAtQuietest = 9999;
            int quietestHour = 0;
            int index = 0;
            
            while(index < hourCounts.length - 1){
                if (numberOfAccessesAtQuietest > hourCounts[index]){
                    quietestHour = index;
                    numberOfAccessesAtQuietest = hourCounts[index];
                    index++;
                }
                else {
                    index++;
                }
            }
            return quietestHour;
    }
    
    public int twobusiestHour()
    {
            int numberOfAccessesAtBusiest = 0;
            int busiestHour = 0;
            int index = 0;
            
            while(index < hourCounts.length - 1){
                if (numberOfAccessesAtBusiest < hourCounts[index] + hourCounts[index + 1]){
                    busiestHour = index;
                    numberOfAccessesAtBusiest = hourCounts[index] + hourCounts[index + 1];
                    index++;
                }
                else {
                    index++;
                }
            }
            return busiestHour;

    
        }
    }
