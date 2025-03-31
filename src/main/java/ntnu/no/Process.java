package ntnu.no;

/**
 * Process class representing a process in a scheduling algorithm.
 * It contains attributes such as process ID, arrival time, burst time,
 * remaining time, priority, start time, and completion time.
 */
public class Process {
    int pid, arrivalTime, burstTime, priority;
    int remainingTime, startTime = -1, completionTime;

    /**
     * Constructor to initialize a process with its attributes.
     * @param pid Process ID
     * @param arrivalTime Arrival time of the process
     * @param burstTime Burst time of the process
     * @param priority Priority of the process (lower number = higher priority)
     */
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }

    /**
     * Constructor to initialize a process for FCFS scheduling (no priority).
     * @param pid Process ID
     * @param arrivalTime Arrival time of the process
     * @param burstTime Burst time of the process
     */
    public Process(int pid, int arrivalTime, int burstTime) {
        this(pid, arrivalTime, burstTime, -1);
    }
}
