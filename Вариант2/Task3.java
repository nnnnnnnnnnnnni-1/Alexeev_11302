package ClassWork2;

public class Task3 {
    public static int[][] array;

    public static void main(String [] args){
        int[] arr1 = {8, 14};
        int[] arr2 = {7, 15, 16};
        int[] arr3 = {8, 13};
        int[] arr4 = {9, 12, 15, 17};
        full(arr1);
        full(arr2);
        full(arr3);
        full(arr4);
    }

    public void init (int n){
        array = new int[n][15];
    }
    public static void full(int[] arr){
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                array[i] = arr;
            }
        }
    }

    public char[][] enter(){
        int[] time = new int[15];
        int i = 0;
        int count = 0;
        for (int j = 0; j < array.length; j++){
            while (array[i] != null || i < array.length){
                time[i+1] = array[j][i];
                i++;
            }
        }
        for (int k = 0; k < array.length; k++){
            System.out.println(time[k] + )
        }
    }
}
