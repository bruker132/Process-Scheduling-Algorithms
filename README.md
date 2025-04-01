# CPU Scheduling Algorithms -FCFS & Preemptive Priority

-**First Come First Serve (FCFS)**
-**Preemptive Priority Scheduling**

# Project Structure

-Process.java                 (Holds process structure and states)

-FCFS.java                    (FCFS scheduling implementation)

-PreemptivePriority.java      (Preemptive Priority scheduling logic)

-Main.java                    (Main class to run the scheduling algorithms)


# How to run the project
- Clone the repository

- Open the project in Intellij

- Run the Main.java file

- Input the number of the CPU Scheduling algorithm you want to test

- Input the number of processes you want to test

- Input the process details (arrival time, burst time, priority) for each process

- the program will show the results of the scheduling algorithm you selected.


# Team Members
- Binit Dhungana

- Bakri Abdulrahman Ahmad

# What we have learned

- We have gained understanding of how different CPU scheduling algorithms work in operating systems.


- We learned that this is a non-preemptive algorithm where processes are executed in the order of 
their arrival. It is simple to implement but can lead to long waiting times for shorter processes 
if a long process comes first (known as the convoy effect).


- We learned that this algorithm always selects the highest-priority process at any given time. 
If a new process arrives with a higher priority, it can interrupt the currently running process.
This made us understand how operating systems manage multitasking and time-sharing effectively.

# Collaboration

- We collaborated using GitHub for version control and project management.

- We communicated regularly, shared code through GitHub, and reviewed each other's contributions.

