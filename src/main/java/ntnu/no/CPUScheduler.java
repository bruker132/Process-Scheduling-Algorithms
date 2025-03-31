package ntnu.no;

import java.util.*;

class CPUScheduling {

    static class FCFSProcess {
        String pid;
        int arrival;
        int burst;
        int waiting;
        int turnaround;

        public FCFSProcess(String pid, int arrival, int burst) {
            this.pid = pid;
            this.arrival = arrival;
            this.burst = burst;
        }
    }

    static class PriorityProcess {
        String pid;
        int arrival;
        int burst;
        int priority;
        int remaining;
        Integer completion;

        public PriorityProcess(String pid, int arrival, int burst, int priority) {
            this.pid = pid;
            this.arrival = arrival;
            this.burst = burst;
            this.priority = priority;
            this.remaining = burst;
            this.completion = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CPU Scheduling Algorithms");
        System.out.println("1. First Come First Serve (FCFS)");
        System.out.println("2. Pre-emptive Priority Scheduling");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            fcfsScheduling();
        } else if (choice == 2) {
            priorityPreemptiveScheduling();
        } else {
            System.out.println("Invalid choice!");
        }
        scanner.close();
    }

    private static void fcfsScheduling() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        List<FCFSProcess> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            String pid = scanner.next();
            System.out.print("Enter Arrival Time: ");
            int arrival = scanner.nextInt();
            System.out.print("Enter Burst Time: ");
            int burst = scanner.nextInt();
            processes.add(new FCFSProcess(pid, arrival, burst));
        }

        processes.sort(Comparator.comparingInt(p -> p.arrival));

        int currentTime = 0;
        int totalWaiting = 0;
        int totalTurnaround = 0;

        for (FCFSProcess p : processes) {
            if (currentTime < p.arrival) {
                currentTime = p.arrival;
            }
            int waiting = currentTime - p.arrival;
            int turnaround = waiting + p.burst;

            p.waiting = waiting;
            p.turnaround = turnaround;

            totalWaiting += waiting;
            totalTurnaround += turnaround;

            currentTime += p.burst;
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWaiting / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaround / n);
        scanner.close();
    }

    private static void priorityPreemptiveScheduling() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        List<PriorityProcess> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            String pid = scanner.next();
            System.out.print("Enter Arrival Time: ");
            int arrival = scanner.nextInt();
            System.out.print("Enter Burst Time: ");
            int burst = scanner.nextInt();
            System.out.print("Enter Priority: ");
            int priority = scanner.nextInt();
            processes.add(new PriorityProcess(pid, arrival, burst, priority));
        }

        processes.sort(Comparator.comparingInt(p -> p.arrival));

        int currentTime = 0;
        int completed = 0;
        int index = 0;
        List<PriorityProcess> readyQueue = new ArrayList<>();
        PriorityProcess currentProcess = null;

        while (completed < n) {
            // Add arriving processes to ready queue
            while (index < n && processes.get(index).arrival <= currentTime) {
                readyQueue.add(processes.get(index));
                index++;
            }

            // Remove finished processes
            readyQueue.removeIf(p -> p.remaining <= 0);

            if (!readyQueue.isEmpty()) {
                // Sort by priority and arrival time
                readyQueue.sort((p1, p2) -> {
                    if (p1.priority != p2.priority) {
                        return Integer.compare(p1.priority, p2.priority);
                    }
                    return Integer.compare(p1.arrival, p2.arrival);
                });

                currentProcess = readyQueue.get(0);
                int timeToRun = 1;
                currentProcess.remaining -= timeToRun;
                currentTime += timeToRun;

                if (currentProcess.remaining == 0) {
                    currentProcess.completion = currentTime;
                    completed++;
                    readyQueue.remove(currentProcess);
                }
            } else {
                currentTime++;
            }
        }

        int totalWaiting = 0;
        int totalTurnaround = 0;
        for (PriorityProcess p : processes) {
            int turnaround = p.completion - p.arrival;
            int waiting = turnaround - p.burst;
            totalWaiting += waiting;
            totalTurnaround += turnaround;
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWaiting / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaround / n);
        scanner.close();
    }
}