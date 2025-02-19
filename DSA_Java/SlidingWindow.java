package DSA_Java;

class SlidingWindow {

    public static int findSubArrayWithLeastAverage(int[] A, int B) {

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

        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        int minSum = sum;
        int minIndex = 0;


        for (int j = B; j < arrLength; j++) {

            //Here I didn't calculate average because if the sum is minimum there obviously the average will also be min.
            sum = sum + A[j] - A[j - B];
            if (sum < minSum) {
                minSum = sum;
                minIndex = j - B + 1;

            }
        }

        return minIndex;
    }


    public static int countGoodSubarrays(int[] A, int B) {
 /*
        Problem Description

        Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
        1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
        2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
        Your task is to find the count of good subarrays in A.


        Problem Constraints

        1 <= len(A) <= 5 x 103
        1 <= A[i] <= 103
        1 <= B <= 107


        Input Format

        The first argument given is the integer array A.
                The second argument given is an integer B.


                Output Format

        Return the count of good subarrays in A.


        Example Input

        Input 1:
        A = [1, 2, 3, 4, 5]
        B = 4
        Input 2:

        A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
        B = 65


        Example Output

        Output 1:
        6
        Output 2:

        36
        */
  
        int n = A.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;


            for (int j = i; j < n; j++) {
                sum += A[j];
                int length = j - i + 1;


                if (length % 2 == 0 && sum < B) {
                    count++;
                } else if (length % 2 == 1 && sum > B) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A1 = {3, 7, 90, 20, 10, 50, 40};
        int B1 = 3;
        System.out.println("findSubArrayWithLeastAverage: " + findSubArrayWithLeastAverage(A1, B1));


        System.out.println("countGoodSubarrays: " + countGoodSubarrays(A1, B1));  // Expected: 6
    }
}