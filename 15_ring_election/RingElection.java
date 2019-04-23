package com.company;

import java.util.*;


public class RingElection {
    private Scanner scanner;
    private SortedSet<Integer> processes;

    public RingElection() {
        System.out.println("\nRing Coordinator Election Algorithm\n");
        scanner = new Scanner(System.in);
        processes = new TreeSet<Integer>();
    }

    public void getInput() {
        System.out.println("Enter number of processes in ring: ");
        int NosOfprocesses = scanner.nextInt();
        for (int i = 0; i < NosOfprocesses; i++) {
            System.out.print("Enter processes ID of p" + i + ": ");
            int pid = scanner.nextInt();
            processes.add(pid);
        }
        showProcesses();
    }

    public void conductElection() {

        while(true){

            System.out.print("Want to conduct Election?(1/0)");
            int choice = scanner.nextInt();

            if(choice==1){

                System.out.println("process:"+ processes.last() +" stopped");
                processes.remove(processes.last());
                int initiatorprocess;

                while(true) {
                    System.out.println("Enter id of election initiator process: ");
                    initiatorprocess = scanner.nextInt();

                    if (processes.contains(initiatorprocess))
                        break;
                    System.out.println("Initiator process not found");
                }

                int prev = initiatorprocess;
                int next;

                List<Integer> message = new ArrayList();
                
                do{
                    next = getNextId(prev);

                    message.add(prev);
                    System.out.println("processes "+ prev +" pass message to processes "+next);
                    showMessageList(message);

                    prev = next;
                }while(next!=initiatorprocess);

                System.out.println("processes "+ processes.last() +" becomes coordinator");
            } else {
                break;
            }
        }
    }

    public int getNextId(int prev){
        boolean returnNext=false;
        for(int x:processes){
            if(returnNext)
                return x;
            if(x==prev)
                returnNext = true;
        }
        return processes.first();
    }

    public void showMessageList(List<Integer> integers){
        System.out.print("[");
        for(int x : integers ){
            System.out.print(x+",");
        }
        System.out.println("]");
    }

    public void showProcesses(){
        System.out.print("processeses in the ring:\n[");
        for(int i : processes){
            System.out.print(i);
            if(i == processes.last()){
                System.out.print("(Coordinator),");
            }else {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String arg[]) {
        RingElection ringElection = new RingElection();
        ringElection.getInput();
        ringElection.conductElection();

    }
}