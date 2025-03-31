package ntnu.no;

public class Process {
    int pid, arrivalTime, burstTime, priority;
    int remainingTime, startTime = -1, completionTime;

    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }

    public Process(int pid, int arrivalTime, int burstTime) {
        this(pid, arrivalTime, burstTime, -1); // FCFS doesn't need priority
    }
}