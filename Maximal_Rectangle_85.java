/**
[["0","1","1","0","1"],
 ["1","1","0","1","0"],
 ["0","1","1","1","0"],
 ["1","1","1","1","0"],
 ["1","1","1","1","1"],
 ["0","0","0","0","0"]]
 * this example shows the difference of this question to the one with square
 */
 
 
 class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n]; // left boundary for current height
        int[] right = new int[n]; // right boundary for current height: rightmost valid one + 1 so that length = (right - left)
        int[] height = new int[n];
        Arrays.fill(right, n);
        int ans = 0;
        
        for (int i = 0; i < m; i++) { // for row i
            // pointer for left and right
            int cur_left = 0, cur_right = n;
            
            for (int j = 0; j < n;j++) { // for col j
                // the max height that can be achieve for that cell 
                if (matrix[i][j] == '1') {
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            
            // look for left most boundary for that cell with the same height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1' ) {
                    left[j] = Math.max(left[j], cur_left); // the closest zero before would have been recorded by cur_left
                }else {
                    left[j] = Integer.MIN_VALUE;  // can be any value as height would be zero ( but need to be small , 0 here would be enough) 
                    cur_left = j+1;  // 
                }
            }
            
            for (int j = n-1; j>=0;j--) { // from right to left
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                }else {
                    right[j] = Integer.MAX_VALUE;  // can be any value as height would be zero ( large , n here would be enough)
                    cur_right = j;
                }
            }
            
            for (int j = 0; j< n;j++) {
                ans = Math.max((right[j] - left[j]) * height[j], ans);
            }
            
        }
        return ans;
    }
}
