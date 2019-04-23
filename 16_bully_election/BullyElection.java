import java.io.*;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class BullyElection{
    int n;
    SortedSet<Integer> processes;
    int leader;
    Scanner in;

    public BullyElection(){
        processes = new TreeSet<>();
    }
    public static void main(String args[])throws IOException
    {
        BullyElection BullyElection = new BullyElection();
        BullyElection.run();
    }


    public void run(){
        System.out.println("\nBully Coordinator Election Algorithm\n");
        System.out.println("Enter the number of process");
        in = new Scanner(System.in);
        n = in.nextInt();

        for(int i=0;i<n;i++){
            System.out.println("Enter Process Id:");
            processes.add(in.nextInt());
        }
        leader = processes.last();
        while(true){
            election();
            System.out.println("Final coordinator is "+leader);
            System.out.println("Want to do it again?(1/0)");
            if(in.nextInt() == 0)
                break;
        }
    }


    public void election()
    {
        int ele;
        while(true) {
            System.out.println("Which process will initiate election?");
            ele = in.nextInt();
            if(processes.contains(ele) && ele != leader){
                break;
            }
            System.out.println("Process with id "+ ele + " is either a leader or not found");
        }
        System.out.println("Process("+ele+") realised that leader process ("+leader+") is dead");
        processes.remove(leader);
        leader = broadcast(ele);
    }

    int broadcast(int i){
        for(int x  :processes){
            if(x!=i){
                System.out.println("Process "+i+" sends its id to process "+x);
                if(x>i){
                    System.out.println("Process "+x+" responds with higher priority");
                    return broadcast(x);
                }else{
                    System.out.println("Process "+x+" failed to respond");
                }
            }
        }
        // i is on highest priority
        // i elects itself as the leader
        System.out.println("Process "+i+" has elected itself as the coordinator");
        return i;
    }
}

