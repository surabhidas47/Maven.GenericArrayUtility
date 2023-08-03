package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

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

    }


}