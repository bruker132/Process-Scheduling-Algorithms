package ntnu.no;

import java.util.Comparator;
import java.util.List;

public class FCFS {
    public void run(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int time = 0;
        int totalWaiting = 0, totalTurnaround = 0;

        System.out.println("\nFCFS Scheduling:");
        for (Process p : processes) {
            if (time < p.arrivalTime) time = p.arrivalTime;
            p.startTime = time;
            p.completionTime = time + p.burstTime;
            int turnaroundTime = p.completionTime - p.arrivalTime;
            int waitingTime = turnaroundTime - p.burstTime;

            totalWaiting += waitingTime;
            totalTurnaround += turnaroundTime;
            time += p.burstTime;

            System.out.println("Process " + p.pid +
                    " | Waiting Time: " + waitingTime +
                    " | Turnaround Time: " + turnaroundTime);
        }

        int n = processes.size();
        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaiting / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaround / n);
    }
}
