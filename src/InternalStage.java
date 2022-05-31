public class InternalStage extends Stage{

    /*-------------------------------------Class Variables-------------------------------------*/
    private double avgProcessingTime;
    private double rngProcessingTime;
    private int numberOfStages;
    private boolean isProcessing;
    private double finishTime;
    private boolean starving;
    private boolean blocked;
    private InterStageQueue<Widget> nextQueue;
    private InterStageQueue<Widget> prevQueue;
    private Widget currentWidget;


    /*-------------------------------------Constructors-------------------------------------*/

    public InternalStage() {
        starving = true;
        blocked = false;
        isProcessing = false;
        currentWidget = null;
    }

    public InternalStage(double avgProcessingTime, double rngProcessingTime, int numberOfStages, InterStageQueue<Widget> nextQueue, InterStageQueue<Widget> prevQueue) {
        this();
        this.avgProcessingTime = avgProcessingTime;
        this.rngProcessingTime = rngProcessingTime;
        this.numberOfStages = numberOfStages;
        this.nextQueue = nextQueue;
        this.prevQueue = prevQueue;
    }

    /*-------------------------------------In/Out Functions-------------------------------------*/
    @Override
    public void in(){                                                                                                   //TODO validate this
        if(prevQueue.isEmpty()){
            starving = true;
        }
        else{
            currentWidget = prevQueue.pop();
            starving = false;
            isProcessing = true;
        }
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

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

    @Override
    public double getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public boolean isStarving() {
        return starving;
    }

    public void setStarving(boolean starving) {
        this.starving = starving;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public InterStageQueue<Widget> getNextQueue() {
        return nextQueue;
    }

    public void setNextQueue(InterStageQueue<Widget> nextQueue) {
        this.nextQueue = nextQueue;
    }

    public InterStageQueue<Widget> getPrevQueue() {
        return prevQueue;
    }

    public void setPrevQueue(InterStageQueue<Widget> prevQueue) {
        this.prevQueue = prevQueue;
    }

    public Widget getCurrentWidget() {
        return currentWidget;
    }

    public void setCurrentWidget(Widget currentWidget) {
        this.currentWidget = currentWidget;
    }
}
