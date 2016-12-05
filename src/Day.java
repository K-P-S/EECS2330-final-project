public class Day {
    // time[half hour of day] = task name
    private String[] time;
    private String name;

    public Day(int dayOfWeek) {
        // Time represented by half hours
        time = new String[47];
        setName(dayOfWeek);
    }

    public String get(int hour)
    {
        return time[hour];
    }

    public void set(int pos, String task){
        time[pos] = task;
    }

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
            double a = i/2;

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
