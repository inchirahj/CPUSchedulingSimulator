# CPUSchedulingSimulator

The Assignment:
------------------
You must complete a program that implements the simulation using one of the following algorithms: FIFO (First In, First Out), SJF (Shortest Job First), STCF (Shortest Time to Completion First), or RR (Round Robin). Your simulation will randomly generate processes to test your policy. You can use any programming language that you want (see above), but however you implement it, you MUST include the following constants:
- CHANCE_OF_ARRIVAL: This percentage represents the chance that a job will arrive in a particular second. This constant can be between 0 and 100: if it is 0, no processes will ever arrive; if it is 100, a process will arrive every second.
- MIN_TIME: This number represents the minimum running time a new process can take.
- MAX_TIME: This number represents the maximum running time a new process can take.
- END_TIME: This number represents the ending time for the simulation.
- TIME_QUANTUM: This number represents the time quantum for the algorithm. It is not necessary for algorithms that do not require a time quantum.
These constants must be clearly defined and named in this manner, and easily found in your code. The point is that they should be able to be easily changed to modify the simulation. I will modify them when testing your code.
Each second in the simulation, you should generate a random number (between 0 and 99) to see if a new process arrives. If it does, you should randomly generate its needed running time (so it is between the minimum and maximum), and add it to the collection of ready processes. The CPU should execute the currently running process for 1 second, and (depending on the algorithm), decide to switch processes. Continue this process until the end time is reached.

Output:
--------
While your simulation is running, it should print each second:
- Any job that arrives (jobs can be numbered as they arrive for reference).
- The job currently running on the CPU.
- Any jobs waiting to be run.

For example, one second of execution might look like this:
Second 67:
Job #32 arrives, requiring 4 seconds to complete. Job #23 is running on the CPU, with 2 seconds left. Jobs #24, 25, 26, 27, 28, 29, 30, 31 are waiting.
This should print for every second of the simulation.

When the simulation ends, you should also print information for each job:
- The job number
- When that job arrived
- When that job finished
- The job’s turnaround time
- The job’s response time
For example, one job’s information might be:
Job #4 arrived at time 6 and finished at time 13. Its turnaround time was 7 and response time was 3.
This information should be printed for each job. If the job did not finish, print just its number and its arrival time.
