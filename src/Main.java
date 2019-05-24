
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("-----------------FCFS----------------");
        fcfs();
        
    }
    
    public static void fcfs()
    {
        CPUScheduler fcfs = new FirstComeFirstServe();
        fcfs.add(new Row("P1", 0, 5));
        fcfs.add(new Row("P2", 2, 4));
        fcfs.add(new Row("P3", 4, 3));
        fcfs.add(new Row("P4", 6, 6));
        fcfs.process();
        display(fcfs);
    }
    
    
    
    
    public static void display(CPUScheduler object)
    {
        System.out.println("Process\tAT\tBT\tWT\tTAT");

        for (Row row : object.getRows())
        {
            System.out.println(row.getProcessName() + "\t" + row.getArrivalTime() + "\t" + row.getBurstTime() + "\t" + row.getWaitingTime() + "\t" + row.getTurnaroundTime());
        }
        
        System.out.println();
        
        for (int i = 0; i < object.getTimeline().size(); i++)
        {
            List<Event> timeline = object.getTimeline();
            System.out.print(timeline.get(i).getStartTime() + "(" + timeline.get(i).getProcessName() + ")");
            
            if (i == object.getTimeline().size() - 1)
            {
                System.out.print(timeline.get(i).getFinishTime());
            }
        }
        
        System.out.println("\n\nAverage WT: " + object.getAverageWaitingTime() + "\nAverage TAT: " + object.getAverageTurnAroundTime());
    }
}
