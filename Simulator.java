import java.util.ArrayList;
import java.util.Random;

public class Simulator
{

  int CHANCE_OF_ARRIVAL = 100;
  int MIN_TIME = 1;
  int MAX_TIME = 5;
  int END_TIME = 20;
  int jobNumber = 0;
  ArrayList<Process> waiting = new ArrayList<>();
  ArrayList<Process> ready = new ArrayList<>();
  ArrayList<Process> finished = new ArrayList<>();
  Random r = new Random();
  int time;

  public void run()
  {

    System.out.println();
    System.out.println("------------------------------");
    System.out.println("  CPU SCHEDULING SIMULATOR");
    System.out.println("  FIFO (First In, First Out)");
    System.out.println("------------------------------");
    System.out.println();
    
    for (int time = 0; time < END_TIME; time++)
    {
      // Check if a new process arrives. If it does, add it to the waiting ArrayList.
      
      System.out.println("Second " + time + ":");
      if(r.nextInt(100) < CHANCE_OF_ARRIVAL)
      {
        int rt = r.nextInt(MAX_TIME - MIN_TIME) + MIN_TIME;
        Process p = new Process(jobNumber, time, rt);
        waiting.add(p);
        System.out.println("Job #" + p.getId() + " arrives, requiring " + p.getRunningTime() + " seconds to complete.");
        jobNumber++;
      }

      // Move the new process to the ready ArrayList.
      Process r;
      if(ready.isEmpty() && !waiting.isEmpty())
      {
        ready.add(waiting.get(0));  
        waiting.remove(0);
        r = ready.get(0);
        r.setFirstRun(time);
      }

      // Print the process that is running. If the process is done, move it to the finished ArrayList.
      Process r2;
      if(!ready.isEmpty())
      {
        r2 = ready.get(0);
        if (time == r2.getFirstRun() + r2.getRunningTime() - 1 )
        {
          r2.setCompletionTime(time);
          finished.add(r2);
          ready.remove(0);
        }
          System.out.println("Job #" + r2.getId() + " is running on the CPU, with " + ((r2.getFirstRun() + r2.getRunningTime()) - time) + " second(s) left.");
      }

      // Print the jobs that are waiting.
      if(!waiting.isEmpty())
      {
        System.out.print("Job #");
        for (int j = 0; j < waiting.size(); j++)
        {
          Process w = waiting.get(j);
          System.out.print(w.getId() + ", ");
        }
        System.out.print("are waiting.");
        System.out.println();
      }
          
    }

    // Output after the simulation is done.
    
    System.out.println();
    System.out.println("--------------------------------------");
    System.out.println();

    // Print the jobs that finished.
    Process f;
    for (int i = 0; i < finished.size(); i++)
    {
      f = finished.get(i);
      System.out.println("Job #" + f.getId() + " arrived at time " + f.getArrivalTime() + " and finished at time " + f.getCompletionTime() + ".");
      
      System.out.println("Its turnaround time was " + (f.getCompletionTime() - f.getArrivalTime()) + " and response time was " + (f.getFirstRun() - f.getArrivalTime()) + ".");
    }

    // Print the processes that are still running (if there are any). 
    Process sr;
    for (int i = 0; i < ready.size(); i++)
    {
      sr = ready.get(i);
      System.out.println("Job #" + sr.getId() + " arrived at time " + sr.getArrivalTime() + ".");
    }

    // Print the processes that did not finish (if there are any).
    Process nf;
    for (int i = 0; i < waiting.size(); i++)
    {
      nf = waiting.get(i);
      System.out.println("Job #" + nf.getId() + " arrived at time " + nf.getArrivalTime() + ".");
    }

    
    
}


}
