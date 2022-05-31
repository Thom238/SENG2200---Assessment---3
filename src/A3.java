import java.util.PriorityQueue;

public class A3 {
    private static final double SIMTIME = 10000000;
    private static final int numOfStages = 6;
    private static double currentTime;
    private static double averageProcessingTime;
    private static double rangeProcessingTime;
    private static int maxQueueSize;
    private static PriorityQueue<Stage> orderOfEvents;
    private static Stage S0A;
    private static Stage S0B;
    private static Stage S1;
    private static Stage S2;
    private static Stage S3A;
    private static Stage S3B;
    private static Stage S4;
    private static Stage S5A;
    private static Stage S5B;
    private static InterStageQueue<Widget> Q01;
    private static InterStageQueue<Widget> Q12;
    private static InterStageQueue<Widget> Q23;
    private static InterStageQueue<Widget> Q34;
    private static InterStageQueue<Widget> Q45;
    private static InterStageQueue<Widget> Q56;



    public static void main(String[] args) {
        averageProcessingTime = Double.parseDouble(args[0]);
        rangeProcessingTime = Double.parseDouble(args[1]);
        maxQueueSize = Integer.parseInt(args[2]);
        currentTime = 0;
        orderOfEvents = new PriorityQueue<Stage>();



        /*-------------------------------------Debugging and Testing------------------------------------*/ //TODO remove this
        Stage test = new StartStage('a',averageProcessingTime,rangeProcessingTime,null);
        ((StartStage) test).calculateFinishTime();
        System.out.println(test.getFinishTime());


    }

    /*-------------------------------------Initialisation Function------------------------------------*/
    public static void initialise(){


    }

    /*-------------------------------------Getters-------------------------------------*/
    public static double getCurrentTime() {
        return currentTime;
    }
}
