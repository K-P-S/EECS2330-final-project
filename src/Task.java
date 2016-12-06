/**
 * A Task object that contains getters and setters for the different attributes of Task
 */
public class Task implements Comparable{

    private String name;
    private double timeNeeded;
    private double day;
    private double time;
    private double priority;

    /**
     * Constructor that initializes name, time needed to complete task, day due, and time due
     * Constructor will also automatically calculate priority of task
     * @param name Name of task
     * @param timeNeeded Time required to complete task in hours
     * @param day Day due (0-6) (Sunday-Saturday)
     * @param time Hour of day due (0-23.5)
     */
    public Task(String name, double timeNeeded, double day, double time){
        this.name=name;
        this.timeNeeded = timeNeeded;
        this.day=day;
        this.time=time;
        this.priority = brianCalculatePriority(time, day, time);
    }

    /**
     * Getter for name of task
     * @return Name of task
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for time needed to complete task
     * @return Time needed to complete task in hours
     */
    public double getTimeNeeded() {
        return timeNeeded;
    }

    /**
     * Get priority of task. Higher priority value means more urgent
     * @return Priority of task relative to schedule
     */
    public double getPriority(){
        return priority;
    }

    /**
     * Keegan's method for calculating priority
     * @param timeNeeded Time needed to complete task
     * @param dayDue Day due (0-6) (Sunday-Saturday)
     * @param timeDue Hour of day due (0-23.5)
     * @return
     */
    private double keeganBetterCalculatorPriority(double timeNeeded, double dayDue, double timeDue)
    {
        //assume adding on Sunday
        return timeNeeded * ((dayDue*24 + timeDue)-timeNeeded);
    }

    /**
     * Brian's method for calculating priority
     * @param timeNeeded Time needed to complete task
     * @param dayDue Day due (0-6) (Sunday-Saturday)
     * @param timeDue Hour of day due (0-23.5)
     * @return
     */
    private double brianCalculatePriority(double timeNeeded, double dayDue, double timeDue){
        return timeNeeded * (6.235 - (dayDue + (timeDue / 100)));
    }

    /**
     * Overridden compareTo method that compares based on priority values
     * @param o Task to compare against
     * @return Difference between priority values
     */
    @Override
    public int compareTo(Object o) {
        return (int)(this.priority - ((Task)o).getPriority());
    }

    public String toString(){
        return getName();
    }
}
