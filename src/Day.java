/**
 * Day class with an array of size 48 representing each half hour of the day.
 * Day has a method to add a class to the Day's schedule
 */
public class Day {

    // time[half hour of day] = task name
    private String[] time;
    private String name;

    /**
     * Constructor for day. Initializes the day into half hours (0-47) and sets the name of the day.
     * @param dayOfWeek Integer from 0-6 representing Sunday-Saturday
     */
    public Day(int dayOfWeek) {
        // Time represented by half hours
        time = new String[47];
        setName(dayOfWeek);
    }

    /**
     * Gets the task reserved for the given hour
     * @param hour Time of day in hours (0-23.5)
     * @return Task at the given hour
     */
    public String get(double hour)
    {
        return time[(int)(hour*2)];
    }


    /**
     * Sets the task at the given hour
     * @param hour Time of day in hours (0-23.5)
     * @param task Task to be reserved at that hour
     */
    public void set(double hour, String task){
        time[(int)(hour*2)] = task;
    }

    /**
     * Convert dayOfWeek from int to String
     * @param dayOfWeek Integer from 0-6 representing the day of week Sunday-Monday
     */
    private void setName(int dayOfWeek){
        switch(dayOfWeek) {
            case 0:
                name = "Sunday";
                break;
            case 1:
                name = "Monday";
                break;
            case 2:
                name = "Tuesday";
                break;
            case 3:
                name = "Wednesday";
                break;
            case 4:
                name = "Thursday";
                break;
            case 5:
                name = "Friday";
                break;
            case 6:
                name = "Saturday";
                break;
        }
    }

    /**
     * Add a class to the daily schedule
     * @param className Name of class
     * @param startTime Time the class starts in hour (0-23.5)
     * @param endTime Time the class ends in hour (0-23.5)
     */
    public void addClass(String className, double startTime, double endTime) {
        startTime *= 2;
        endTime *= 2;

        for (double i = startTime; i < endTime; i++) {
            time[(int) i] = className;
        }

    }

    public String toString()
    {
        String output = name + "\n";

        for (int i=0; i<time.length ; i++)
        {
            //TODO: Keegan, time
            double a = ((double)i)/2;

            if(time[i]!= null)
            {
                output+= a + " : " + time[i] + "\n";
            }
            else
            {
                output+= a + " : " + "free time" + "\n";
            }
        }

        return output;
    }

}
