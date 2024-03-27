package MergeSort;

import java.util.Objects;

public class MergeSort {
    public static int countIterations = 0;
    public static int[] mergeArrays(int[] arrayA, int[] arrayB){
        countIterations++;
        int positionA = 0;
        int positionB = 0;
        int[] arrayC = new int[arrayA.length + arrayB.length];

        for (int i = 0; i < arrayA.length + arrayB.length; i++){
            countIterations++;
            if (positionA == arrayA.length){
                arrayC[arrayA.length + positionB] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length){
                arrayC[arrayB.length + positionA] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] >= arrayB[positionB]){
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (arrayA[positionA] < arrayB[positionB]){
                arrayC[i] = arrayA[positionA];
                positionA++;
            }
        }
        return arrayC;
    }
    public int[] sortArray(int[] arrayA){
        countIterations++;
        if (arrayA.length == 0) return null;
        if (arrayA.length == 1) return arrayA;

        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        return mergeArrays(Objects.requireNonNull(sortArray(arrayB)), Objects.requireNonNull(sortArray(arrayC)));
    }

}
