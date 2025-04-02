public class Matrices {


    public static int findRainWaterTrapped(int[] A){

        /*
        Problem Description

Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.

Your task is to calculate the total amount of water that can be trapped in these valleys.

Example:

The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.

Problem Constraints

1 <= |A| <= 105
0 <= A[i] <= 105



Input Format

First and only argument is the Integer Array, A.



Output Format

Return an Integer, denoting the total amount of water that can be trapped in these valleys



Example Input

Input 1:

 A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output

Output 1:

1
Output 2:

0

         */

        int len = A.length;
        if (len <= 2) {
            return 0; // No water can be trapped with less than 3 bars
        }

        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        int[] waterTrapped = new int[len]; // store water based on leftMax


        for (int i = 0; i < len; i++) {
            leftMax = Math.max(leftMax, A[i]);
            waterTrapped[i] = leftMax;
        }



        for (int i = len - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, A[i]);

            result += Math.min(waterTrapped[i], rightMax) - A[i];
        }

        return result;

    }

    public static void main(String[] args){
        int[] Bars = {0,10,5,8};
        System.out.println("Total water trapped: " + findRainWaterTrapped(Bars));
    }
}
