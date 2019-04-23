package com.clouway;

public class ArrayOperator {
    public ArrayOperator() {
    }

    /**
     * Gets min integer from int array
     * @param array array from which min is determined
     * @return 0 if array is empty or min element
     */
    public int getMinElement(int[] array){
        if(array.length>0) {
            int result = array[0];
            for (int num:array) {
                if(result>num){
                    result = num;
                }
            }
            return result;
        }else {
            System.out.println("Array is empty");
            return 0;
        }
    }

    /**
     * Sums every integer in array
     * @param array array being summed
     * @return sum of every int
     */
    public int getSum(int[] array){
        int result = 0;
        for (int num: array) {
            result += num;
        }
        return result;
    }

    /**
     * Prints every integer from array
     * @param array array being printed
     */
    public void printArray(int[] array){
        for (int num:array) {
            System.out.print(num+" ");
        }
    }

}