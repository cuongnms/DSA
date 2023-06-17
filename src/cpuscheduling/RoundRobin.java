package cpuscheduling;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    static class Process {
        int id;
        int arrivalTime;
        int excuteTime;
        int remainExcuteTime;
        int waitingTime;
        boolean isComplete;
        boolean inQueue;

        public Process() {
        }

        public Process(int id, int arrivalTime, int excuteTime, int remainExcuteTime, int waitingTime, boolean isComplete, boolean inQueue) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.excuteTime = excuteTime;
            this.remainExcuteTime = remainExcuteTime;
            this.waitingTime = waitingTime;
            this.isComplete = isComplete;
            this.inQueue = inQueue;
        }
    }

    public void roundRobin(Process[] processes, int n, int quantum){
        Queue<Integer> readyQueue = new LinkedList<>();
        readyQueue.add(0);
        processes[0].inQueue = true;
        Integer currenTime = 0;
        int programExcuted = 0;
        while(!readyQueue.isEmpty()){
            currenTime = updateQueue(processes, n, quantum, readyQueue, currenTime, programExcuted);
        }
    }

    private int updateQueue(Process[] processes, int n, int quantum, Queue<Integer> readyQueue, Integer currenTime, int programExcuted) {
        int i = readyQueue.remove();
        if(processes[i].remainExcuteTime <= quantum){
            System.out.println("From " + currenTime + " to " + (currenTime + processes[i].remainExcuteTime) + ": Process " + processes[i].id + " handle request ");
            processes[i].isComplete = true;
            currenTime += processes[i].remainExcuteTime;
            processes[i].remainExcuteTime = 0;
            if(programExcuted!=n){
                checkForNewArrivals(processes, n, currenTime, readyQueue);
            }
        }else{
            System.out.println("From " + currenTime + " to " + (currenTime + quantum) + ": Process " + processes[i].id + " handle request ");
            processes[i].remainExcuteTime -= quantum;
            currenTime+= quantum;
            if(programExcuted !=n){
                checkForNewArrivals(processes, n, currenTime, readyQueue);
            }
            readyQueue.add(i);
        }
        return currenTime;
    }

    private void checkForNewArrivals(Process[] processes, int n, Integer currenTime, Queue<Integer> readyQueue) {
        for(int i = 0 ; i < n; i++){
            Process p = processes[i];
            if(p.arrivalTime <= currenTime && !p.inQueue && !p.isComplete){
                processes[i].inQueue = true;
                readyQueue.add(i);
            }
        }
    }

    public static void main(String[] args) {
        RoundRobin r = new RoundRobin();
        Process[] processes = new Process[4];
        processes[0] = new Process();
        processes[0].id = 1;
        processes[0].arrivalTime = 0;
        processes[0].excuteTime = 5;
        processes[0].remainExcuteTime = 5;

        processes[1] = new Process();
        processes[1].id = 2;
        processes[1].arrivalTime = 1;
        processes[1].excuteTime = 4;
        processes[1].remainExcuteTime = 4;

        processes[2] = new Process();
        processes[2].id = 3;
        processes[2].arrivalTime = 2;
        processes[2].excuteTime = 2;
        processes[2].remainExcuteTime = 2;

        processes[3] = new Process();
        processes[3].id = 4;
        processes[3].arrivalTime = 4;
        processes[3].excuteTime = 1;
        processes[3].remainExcuteTime = 1;
        r.roundRobin(processes, 4,2);
    }
}
