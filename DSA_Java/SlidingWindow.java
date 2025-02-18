package  DSA_Java;

class SlidingWindow {

    public static int findSubArrayWithLeastAverage(int[] A, int B){

        /*
Problem Description: Given an array A of size N, find the subarray of size B with the least average.
Problem Constraints:
    1 <= B <= N <= 105
    -105 <= A[i] <= 105

Input Format:
First argument contains an array A of integers of size N.
Second argument contains integer B.

Output Format:
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.

Example Input:
Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:
A = [3, 7, 5, 20, -10, 0, 12]
B = 2

Example Output

Output 1:
3
Output 2:
4

Example Explanation

Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.
Explanation 2:
Subarray between [4, 5] has minimum average
         */
        int sum = 0;
        int arrLength = A.length;

        for(int i=0; i< B; i++){
            sum += A[i];
        }

        int minSum = sum;
        int minIndex = 0;


        for(int j = B; j < arrLength; j++){

            //Here I didn't calculate average because if the sum is minimum there obviously the average will also be min.
            sum = sum + A[j] - A[j - B];
            if(sum < minSum){
                minSum = sum;
                minIndex = j - B + 1;

            }
        }

        return minIndex;
    }

    public static void main(String[] args){
        int[] A1 = {3, 7, 90, 20, 10, 50, 40};
        int B1 = 3;
        System.out.println("Output 1: " + findSubArrayWithLeastAverage(A1, B1));
    }
}