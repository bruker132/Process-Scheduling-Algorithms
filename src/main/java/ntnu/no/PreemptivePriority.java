package ntnu.no;
import java.util.*;
/**
 * Preemptive Priority Scheduling Algorithm
 * This class implements the preemptive priority scheduling algorithm.
 * It schedules processes based on their priority and allows preemption.
 */
public class PreemptivePriority {
    /**
     * Runs the preemptive priority scheduling algorithm on a list of processes.
     * @param processes List of processes to be scheduled.
     */
    public void run(List<Process> processes) {
        int n = processes.size();
        int completed = 0, currentTime = 0;
        int totalWaiting = 0, totalTurnaround = 0;

        System.out.println("\nPreemptive Priority Scheduling:");

        // Sort processes based on arrival time
        while (completed < n) {
            Process current = null;
            int highestPriority = Integer.MAX_VALUE;

            // Find the process with the highest priority that has arrived
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && p.priority < highestPriority) {
                    highestPriority = p.priority;
                    current = p;
                }
            }

            // If no process is currently running, move time forward
            if (current == null) {
                currentTime++;
            } else {
                if (current.startTime == -1)
                    current.startTime = currentTime;

                // Execute the current process for one time unit
                current.remainingTime--;
                currentTime++;

                // If the process is completed, calculate waiting and turnaround times
                if (current.remainingTime == 0) {
                    current.completionTime = currentTime;
                    int turnaroundTime = current.completionTime - current.arrivalTime;
                    int waitingTime = turnaroundTime - current.burstTime;


                    totalWaiting += waitingTime;
                    totalTurnaround += turnaroundTime;
                    completed++;


                    System.out.println("Process " + current.pid +
                            " | Waiting Time: " + waitingTime +
                            " | Turnaround Time: " + turnaroundTime);
                }
            }
        }

        // Calculate and print average waiting and turnaround times
        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaiting / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaround / n);
    }
}
