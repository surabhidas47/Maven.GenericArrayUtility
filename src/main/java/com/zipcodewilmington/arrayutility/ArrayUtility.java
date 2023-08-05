package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    //creating generic array so any kind of given string/integer array will work
    private T[] givenArray;

    //constructor
    ArrayUtility(T[] givenArray) {

        this.givenArray = givenArray;
    }

    //first creating method to merge arrays

    private void mergeArrays(T[] arrayToMerge) {

        //creating a copy of our givenArray, standard to do this

        T [] copyInto = Arrays.copyOf(givenArray,givenArray.length+arrayToMerge.length);

        //copying arrayToMerge into bothA
        //System.arraycopy() copies the array contents from the
        // (source array,
        // beginning at the specified position of source array,
        // array to copied into
        //starting position of destination array
        //length of to total to copy

        System.arraycopy(arrayToMerge,0,copyInto,givenArray.length,arrayToMerge.length);
        this.givenArray= copyInto;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        int count =0;

        for (int i=0;i< givenArray.length;i++){
            if(givenArray[i]==valueToEvaluate){
                count++;
            }

        }

        return count;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        //need to return most common object

        //first use mergeArrays method
        mergeArrays((T[]) arrayToMerge);

        int mostCommonNum =0;
        T mostCommonObj = null;

        for (int i=0;i<givenArray.length;i++){
            //storing iteration in current value
            T currentIter = givenArray[i];

            //using getNumOfOccurances
            //know to store in int bc thats what we return in this method
            int count =getNumberOfOccurrences(currentIter);


            // updates the mostCommonValue and mostCommon variables whenever
            // a new maximum count is found during the loop iteration
            if(count>mostCommonNum){
                mostCommonNum=count;
                mostCommonObj=currentIter;
            }


        }

        return mostCommonObj;
    }

    public T[] removeValue(T valueToRemove) {

        List<T> newList = new ArrayList<>();

//        for (int i=0;i<givenArray.length;i++){
//            if(givenArray[i]!=valueToRemove){
//                newList.add(givenArray[i]);
//            }
        for(T check: givenArray){
            if(!valueToRemove.equals(check)){
                newList.add(check);
            }


        }

        T[] result = newList.toArray((T[]) new Object[newList.size()]);


        return result;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        return null;
    }
}