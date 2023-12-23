package ClassWork2.Alexeev_11302.Variant2;
public class Main{
    public static void main(String [] args) throws Exception{
        TimeInterval inter1 = new TimeInterval(2, 70, 120);
        TimeInterval inter2 = new TimeInterval(3, 10, 60);
        inter1.reduce();
        System.out.println(inter1.toString());
        System.out.println(inter1.add(inter2));
        TimeInterval inter3 = new TimeInterval(-2, 5, 3);
    }
}