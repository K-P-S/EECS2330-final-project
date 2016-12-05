public class Task implements Comparable{

    private String name;
    private double timeNeeded;
    private double day;
    private double time;
    private double priority;

    public Task(String name, double timeNeeded, double day, double time){
        this.name=name;
        this.timeNeeded = timeNeeded;
        this.day=day;
        this.time=time;
        this.priority = brianCalculatePriority(time, day, time);
    }

    public String getName() {
        return name;
    }

    public double getDay() {
        return day;
    }

    public double getTime() {
        return time;
    }

    public double getPriority(){
        return priority;
    }

    private double keeganBetterCalculatorPriority(double timeNeeded, double dayDue, double timeDue)
    {
        //assume adding on Sunday
        return timeNeeded * ((dayDue*24 + timeDue)-timeNeeded);
    }

    private double brianCalculatePriority(double timeNeeded, double dayDue, double timeDue){
        return timeNeeded * (6.235 - (dayDue + (timeDue / 100)));
    }

    @Override
    public int compareTo(Object o) {
        return (int)(this.priority - ((Task)o).getPriority());
    }

    public String toString(){
        return getName();
    }
}
