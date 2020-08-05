package com.bernard;

public class ArrayRotation {

    public int[] doRotation(int[] arr, int n){
        int counter = 0,  occupied = 0, preserveN = n;
        int[] tempArr = new int[arr.length];
        int noOfLoop = arr.length - n;

        for(int it = 0; it < noOfLoop; it++, n++){
            tempArr[it] = arr[n];
            occupied++;
        }
        for(int j = occupied; counter < preserveN; j++, counter++){
            tempArr[j] = arr[counter];
        }

        return tempArr;
    }
}
