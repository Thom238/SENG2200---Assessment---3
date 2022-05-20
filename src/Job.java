import java.util.Random;
//TODO finish this class

public class Job {

    /*----------------------------------Variables----------------------------------*/
    double totalProcessingTime;
    double totalBlockedTime;
    double totalStarvedTime;
    double processingTime;
    double rangeProcessingTime;
    boolean blocked;
    boolean starved;

    /*----------------------------------Constructors----------------------------------*/
    public Job() {
        totalProcessingTime = 0;
        totalBlockedTime = 0;
        totalStarvedTime = 0;
        processingTime = 0;
        rangeProcessingTime = 0;
        blocked = true;
        starved = true;
    }

    public Job(double rangeProcessingTime) {
        this.rangeProcessingTime = rangeProcessingTime;
    }
}
