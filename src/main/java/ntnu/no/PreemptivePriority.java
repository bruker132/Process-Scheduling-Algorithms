package ntnu.no;

import java.util.*;

public class PreemptivePriority {
    public void run(List<Process> processes) {
        int n = processes.size();
        int completed = 0, currentTime = 0;
        int totalWaiting = 0, totalTurnaround = 0;
        boolean[] isCompleted = new boolean[n];

        System.out.println("\nPreemptive Priority Scheduling:");

        while (completed < n) {
            Process current = null;
            int highestPriority = Integer.MAX_VALUE;

            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && p.priority < highestPriority) {
                    highestPriority = p.priority;
                    current = p;
                }
            }

            if (current == null) {
                currentTime++;
            } else {
                if (current.startTime == -1)
                    current.startTime = currentTime;

                current.remainingTime--;
                currentTime++;

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

        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaiting / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaround / n);
    }
}