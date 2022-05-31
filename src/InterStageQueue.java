/*
Author: Thomas Bandy
Course: SENG2200
Date: 27/05/2022
Files: A3.java, Widget.java, Stage.java, SerialNumber.java, SplitStage.java
*/
import java.util.LinkedList;
import java.util.Queue;

public class InterStageQueue<T> {

    /*----------------------------------Variables----------------------------------*/
    private Queue<T> queue;
    private final int maxQueueLength;
    private int queueSize;
    private Stage nextStage;

    /*----------------------------------Constructors----------------------------------*/

    public InterStageQueue() {
        this.queue = new LinkedList<T>();
        this.maxQueueLength = 0;
        this.queueSize = 0;
        this.nextStage = null;
    }

    public InterStageQueue(int maxQueueLength, Stage nextStage) {
        this.queue = new LinkedList<T>();
        this.maxQueueLength = maxQueueLength;
        this.queueSize = 0;
        this.nextStage = nextStage;
    }

    /*----------------------------------Mutation Functions----------------------------------*/
    public T pop(){
        this.queueSize--;
        return this.queue.poll();
    }

    public T peek(){
        return this.queue.peek();
    }

    public boolean push(T item){
        if(!fullQueue()){
            this.queue.add(item);
            this.queueSize++;
            return true;
        }
        return false;
    }

    /*----------------------------------Queue State Checks----------------------------------*/
    public boolean fullQueue(){                         //Returns true if queue is full
        return this.queueSize >= this.maxQueueLength;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
