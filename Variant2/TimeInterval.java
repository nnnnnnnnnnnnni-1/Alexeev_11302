package ClassWork2.Alexeev_11302.Variant2;
public class TimeInterval{
    private int hour;
    private int min;
    private int sec;
    public TimeInterval(int hour, int min, int sec) throws Exception{
        if (hour > 0 && min > 0 && sec > 0){
            this.hour = hour;
            this.min = min;
            this.sec = sec;
        } else {
            throw new Exception ("TimeInterval's atributes must be more than zero or equals to zero");
        }
    }
    public int getHour(){
        return hour;
    }
    public int getMin(){
        return min;
    }
    public int getSec(){
        return sec;
    }
    public TimeInterval() throws Exception{
        this(0,0,0);
    }
    public void reduce(){
        min += sec / 60;
        sec %= 60;
        hour += min / 60;
        min %= 60;
    }
    public TimeInterval add(TimeInterval interval) throws Exception{
        TimeInterval result = new TimeInterval(hour + interval.hour, min + interval.min, sec + interval.sec);
        result.reduce();
        return result;
    }
    public TimeInterval mult(int x) throws Exception{
        TimeInterval result = new TimeInterval(hour * x, min * x, sec * x);
        result.reduce();
        return result;
    }
    public String toString() {
        return hour + " hours " + min + " minuts " + sec + " secunds ";
    }
    public boolean equals(TimeInterval interval) throws Exception{
        TimeInterval called = new TimeInterval(hour, min, sec);
        called.reduce();
        interval.reduce();
        return called.hour == interval.hour && called.min == interval.min && called.sec == interval.sec;
    }
}