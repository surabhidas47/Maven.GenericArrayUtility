package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;



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

        //T [] newArray = Arrays.copyOf(array, array.length+arrayToMerge.length);
        T [] newArray = (T[]) Array.newInstance(arrayToMerge[0].getClass(),array.length+arrayToMerge.length);

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

        int counter =0;

        Integer remove = (Integer) getNumberOfOccurrences(valueToRemove);
        //T [] newArray = Arrays.copyOf(array, array.length-remove);
        T [] newArray = (T[]) Array.newInstance(valueToRemove.getClass(),array.length-remove);

        for (int i=0; i<array.length;i++){
            if (!array[i].equals(valueToRemove)){
                newArray[counter]=array[i];
            }
        }

        return newArray;
    }


    public Integer countDuplicatesInMerge(Integer[] arrayToMerge, T valueToEvaluate) {

        T [] newArray = mergeArray((T[]) arrayToMerge);
        this.array = newArray;

        int duplicate = (int) getNumberOfOccurrences(valueToEvaluate);
        return duplicate;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        T [] newArray = mergeArray(arrayToMerge);

        int mostCommon =0;
        T commonObj = null;
        int counter =0;

        for (int i=0;i< newArray.length;i++){
            for (int j=0;i< newArray.length;j++){
                if(newArray[i]==newArray[j]){
                    counter++;
                }
            }
            if (counter>mostCommon){
                mostCommon=counter;
                commonObj=newArray[i];
            }
        }
        return commonObj;
    }


}
