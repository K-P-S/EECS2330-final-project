import java.io.File;
import java.util.Scanner;

public class Scheduler{

    public static void main(String[] args)
    {
        try {
            Scanner s = new Scanner(new File("/Users/home/IdeaProjects/EECS233/src/data.txt"));
            Schedule schedule = new Schedule();
            int n = Integer.parseInt(s.nextLine());
            for(int i = 0; i < n; i++){
                schedule.addClass(s.nextLine());
            }

            n = Integer.parseInt(s.nextLine());
            for(int i = 0; i < n; i++){
                schedule.addTaskToQueue(s.nextLine());
            }
            schedule.addTasksToSchedule();
            System.out.println(schedule);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}