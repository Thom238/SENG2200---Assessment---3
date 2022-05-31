abstract class Stage implements Comparable<Stage> {
    public abstract void in();
    public abstract Widget out();
    public abstract double getFinishTime();
    public abstract double processingTime();

    @Override
    public int compareTo(Stage o){
        if(this.getFinishTime() == o.getFinishTime()){
            return 0;
        }
        else if(this.getFinishTime() > o.getFinishTime()){
            return 1;
        }
        return -1;
    }
}
