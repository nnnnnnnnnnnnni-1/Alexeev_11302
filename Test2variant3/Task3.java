package Test2variant3;
public class Task3{
    public static void main(String[] args){
        int n = 4;
        String n1 = "ajsdhcoqeh";
        String n2 = "dqjcoiwehvwq";
        String n3 = "wqdjcjx";
        String n4 = "djpqjcsdfvs";
        Task3 t = new Task3();
        int[] a = t.array(n1 + n2 + n3 + n4);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    public int[] array (String x){
        int [] array = new int [26];
        for (int i = 0; i < x.length(); i++){
            array[(int) x.charAt(i) - 'a'] += 1;
        }
        return array;
    }


}