

public class StartStage extends Stage {

    /*-------------------------------------Class Variables-------------------------------------*/
    private char letter;
    private double avgProcessingTime;
    private double rngProcessingTime;
    private int numberOfStages;
    private boolean isProcessing;
    private double finishTime;
    private boolean blocked;
    private InterStageQueue<Widget> nextQueue;
    private Widget currentWidget;


    /*-------------------------------------Constructors-------------------------------------*/

    public StartStage() {
        numberOfStages = 7;
        isProcessing = false;
        blocked = false;
    }

    public StartStage(char letter, double avgProcessingTime, double rngProcessingTime, InterStageQueue<Widget> nextQueue) {
        this();
        this.letter = letter;
        this.avgProcessingTime = avgProcessingTime;
        this.rngProcessingTime = rngProcessingTime;
        this.nextQueue = nextQueue;
    }

    /*-------------------------------------In/Out Functions-------------------------------------*/
    public Widget createWidget(){
        return new Widget(numberOfStages, letter);
    }

    @Override
    public void in(){
        this.currentWidget = createWidget();
        calculateFinishTime();
        this.isProcessing = true;
    }

    @Override
    public Widget out(){
        if(nextQueue.fullQueue()){
            blocked = true;
            return null;
        }
        else{
            isProcessing = false;
            blocked = false;
        }
        return currentWidget;

    }

    /*-------------------------------------Mathematical Functions-------------------------------------*/
    @Override
    public double processingTime(){
        return avgProcessingTime + (rngProcessingTime * (Math.random() - 0.5));
    }

    public void calculateFinishTime() {
        finishTime = A3.getCurrentTime() + processingTime();
    }

    /*-------------------------------------Getters and Setters-------------------------------------*/

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public double getAvgProcessingTime() {
        return avgProcessingTime;
    }

    public void setAvgProcessingTime(double avgProcessingTime) {
        this.avgProcessingTime = avgProcessingTime;
    }

    public double getRngProcessingTime() {
        return rngProcessingTime;
    }

    public void setRngProcessingTime(double rngProcessingTime) {
        this.rngProcessingTime = rngProcessingTime;
    }

    @Override
    public double getFinishTime() {
        return finishTime;
    }
}
