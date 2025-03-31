package ntnu.no;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();

        System.out.println("Choose Scheduling Algorithm:");
        System.out.println("1. First Come First Serve (FCFS)");
        System.out.println("2. Preemptive Priority Scheduling");
        int choice = sc.nextInt();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + " details:");
            System.out.print("Process ID: ");
            int pid = sc.nextInt();
            System.out.print("Arrival Time: ");
            int arrival = sc.nextInt();
            System.out.print("Burst Time: ");
            int burst = sc.nextInt();

            if (choice == 2) {
                System.out.print("Priority (lower number = higher priority): ");
                int priority = sc.nextInt();
                processes.add(new Process(pid, arrival, burst, priority));
            } else {
                processes.add(new Process(pid, arrival, burst));
            }
        }

        if (choice == 1) {
            new FCFS().run(processes);
        } else if (choice == 2) {
            new PreemptivePriority().run(processes);
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

