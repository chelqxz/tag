/**
* general solution
*/


/**
* missed inportant k !  i hardcoded the solution for len = 2 ....
*/
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int len) {
        int n = nums.length;
        int[] result = new int[3];
        
        int[][] third = new int[n][4];
        for (int k = n-2; k >= 0; k--) {
            if (nums[k]+nums[k+1] >= third[k+1][0]) { // equal because choose the "smallest" one
                third[k][0] = nums[k]+nums[k+1];
                third[k][1] = k;
            } else {
                third[k][0] = third[k+1][0];
                third[k][1] = third[k+1][1];
            }
        }
        
        int[][] second = new int[n][3];
        for (int j = n-4; j >= 0; j--) {
            if (nums[j] + nums[j+1] + third[j+2][0] >= second[j+1][0]) {
                second[j][0] = nums[j] + nums[j+1] + third[j+2][0];
                second[j][1] = j;
                second[j][2] = third[j+2][1];
            } else {
                second[j][0] = second[j+1][0];
                second[j][1] = second[j+1][1];
                second[j][2] = second[j+1][2];
            }
        }
        
        int[][] first = new int[n][4];
        for (int i = n-6; i >= 0; i--) {
            if (nums[i] + nums[i+1] + second[i+2][0] >= first[i+1][0]) {
                first[i][0] = nums[i] + nums[i+1] + second[i+2][0];
                first[i][1] = i;
                first[i][2] = second[i+2][1];
                first[i][3] = second[i+2][2];
            } else {
                first[i][0] = first[i+1][0];
                first[i][1] = first[i+1][1];
                first[i][2] = first[i+1][2];
                first[i][3] = first[i+1][3];
            }
        }
        result[0] = first[0][1];
        result[1] = first[0][2];
        result[2] = first[0][3];
        return result;
    }
}
