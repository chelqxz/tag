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
        
        int[][] third = new int[n+1][2];
        for (int k = n-len; k >= 0; k--) {
            int sum = 0;
            for (int p = 0; p< len;p++) {
                sum += nums[k+p];
            }
            if (sum >= third[k+1][0]) { // equal because choose the "smallest" one
                third[k][0] = sum;
                third[k][1] = k;
            } else {
                third[k][0] = third[k+1][0];
                third[k][1] = third[k+1][1];
            }
        }
        
        int[][] second = new int[n+1][3];
        for (int j = n-len*2; j >= 0; j--) {
            int sum = 0;
            for (int p = 0; p< len;p++) {
                sum += nums[j+p];
            }
            if (sum + third[j+len][0] >= second[j+1][0]) {
                second[j][0] = sum + third[j+len][0];
                second[j][1] = j;
                second[j][2] = third[j+len][1];
            } else {
                second[j][0] = second[j+1][0];
                second[j][1] = second[j+1][1];
                second[j][2] = second[j+1][2];
            }
        }
        
        int[][] first = new int[n+1][4];
        for (int i = n-len*3; i >= 0; i--) {
            int sum = 0;
            for (int p = 0; p< len;p++) {
                sum += nums[i+p];
            }
            // System.out.println(i + " " +sum + " "+ second[i+2][0]);
            if (sum + second[i+len][0] >= first[i+1][0]) {
                first[i][0] = sum + second[i+len][0];
                first[i][1] = i;
                first[i][2] = second[i+len][1];
                first[i][3] = second[i+len][2];
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
