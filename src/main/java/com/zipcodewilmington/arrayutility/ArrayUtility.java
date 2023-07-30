package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    //creating generic array so any kind of given string/integer array will work
    private T[] array;

    //constructor
    ArrayUtility(T [] givenArray){
        //storing input from given array in genArray
        this.array = givenArray;
    }

    //method to merge arrays for count duplicates and get most common

    public T[] mergeArray(T[] arrayToMerge){

        T [] newArray = Arrays.copyOf(array, array.length+arrayToMerge.length);

        //orginal array into new array

        for (int i=0; i<array.length;i++){
            newArray[i]=array[i];
        }

        //iterating from array.length to array.length + arrayToMerge.length
        //adding mergearray from array.length(gives us the starting index to begin adding into
        for (int i= array.length;i< array.length+arrayToMerge.length;i++){

            newArray[i]=arrayToMerge[i-array.length];
        }
        this.array=newArray;
        return array;

    }


    //methods generated from test


    public T getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter =0;
        for (int i=0; i<array.length;i++){
            if (array[i].equals(valueToEvaluate)){
                counter++;
            }
        }
        return (T) counter;
    }

    public Object[] removeValue(T valueToRemove) {
        return new Object[0];
    }


//    public T countDuplicatesInMerge(Integer[] arrayToMerge, T valueToEvaluate) {
//
//        T [] newArray = mergeArray(arrayToMerge);
//
//        return valueToEvaluate;
//    }






}
