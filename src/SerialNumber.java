/*
Author: Thomas Bandy
Course: SENG2200
Date: 27/05/2022
Files: A3.java, Widget.java, Job.java, InterStageQueue.java
*/
public class SerialNumber {
    int number;
    private static final SerialNumber instance = new SerialNumber();

    private SerialNumber(){
        number = 0;
    }

    public static SerialNumber getInstance() {
        return instance;
    }

    public int getNextNumber(){
        number++;
        return number;
    }
}
