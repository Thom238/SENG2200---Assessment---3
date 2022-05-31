public class Widget {
    /*-------------------------------------Class Variables-------------------------------------*/
    private int stageCounter;
    private int numOfStages = 7;
    private String id;
    private double[] prodTimeStart;
    private double[] prodTimeEnd;

    /*-------------------------------------Constructors-------------------------------------*/
    public Widget(){
        this.prodTimeStart = new double[0];
        this.stageCounter = 0;
    }

    public Widget(int numOfStages, Character letter) {
        this();
        this.numOfStages = numOfStages;
        this.prodTimeStart = new double[numOfStages];
        this.id = String.valueOf(SerialNumber.getInstance().getNextNumber()) + letter;
        prodTimeStart[stageCounter] = A3.getCurrentTime();
    }

    /*-------------------------------------Getters and Setters-------------------------------------*/
    public String getId() {
        return this.id;
    }

    public void setProdTimeEnd(double processingTime) {
        this.prodTimeEnd[stageCounter] = prodTimeStart[stageCounter] + processingTime;
        stageCounter++;
    }
}
