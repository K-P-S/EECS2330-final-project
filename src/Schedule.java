import java.util.PriorityQueue;
import java.util.Scanner;

public class Schedule {
    private Day[] days;
    PriorityQueue<Task> tasks;

    public Schedule(){
        days = new Day[7];
        tasks = new PriorityQueue<>();
        for(int i = 0; i < days.length; i++){
            days[i] = new Day(i);
        }
        addSleep();
    }

    /**
     * Adds class to the schedule
     * @param str String to parse from data.txt
     */
    public void addClass(String str){
        str = str.replace(',', ' ');
        System.out.println(str);
        Scanner s = new Scanner(str);
        String className = s.next();
        String daysHeld = s.next();
        String startTime = s.next();
        String endTime = s.next();

        for(int i = 0; i < daysHeld.length(); i++){
            days[Integer.parseInt(daysHeld.substring(i, i+1))].addClass(className, Double.parseDouble(startTime), Double.parseDouble(endTime));

        }
    }

    /**
     *
     * @param str
     */
    public void addTaskToQueue(String str){
        System.out.println(str);
        str = str.replace(',', ' ');
        Scanner s = new Scanner(str);
        String taskName = s.next();
        double timeNeeded = Double.parseDouble(s.next());
        double dayDue = Double.parseDouble(s.next());
        double timeDue = Double.parseDouble(s.next());
        Task task = new Task(taskName, timeNeeded, dayDue, timeDue);
        tasks.add(task);
    }

    public void addTasksToSchedule(){
        while(!tasks.isEmpty()){
            Task t = tasks.poll();
            System.out.println("TASK" + t);
            boolean taskAdded = false;
            int day = 0;
            double time = 0;
            double timeNeeded = t.getTime();
            while(!taskAdded && day < 7){
                if(time>23) {
                    day++;
                    time=0;
                }
                if(days[day].get((int)(time * 2)) == null) {
                    days[day].set((int)(time * 2), t.getName());
                    timeNeeded -= 0.5;
                }
                if(timeNeeded == 0){
                    taskAdded = true;
                }
                time += 0.5;
            }
        }
    }

    private void addSleep()
    {
        for(Day d: days)
        {
            d.addClass("Sleep", 0, 8);
        }

    }

    public String toString(){
        String output = "";
        for(Day d : days){
            output += d.toString() + "\n";
        }
        return output;
    }
}
