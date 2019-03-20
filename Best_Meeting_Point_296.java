/**
* complexity : O(mn)
*/
class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = new ArrayList<>(); // convert to 1-d problem
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i); // collect all the rows having 1 in sorted order
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j); // collect all the cols having 1 in sorted order
                }
            }
        }
        int col = cols.get(cols.size()/2); // get median 
        int row = rows.get(rows.size()/2); // if even number, this is also fine
        int dist = 0; 
        // |p2.x - p1.x| + |p2.y - p1.y|.
        for (int c : cols) {
            dist += Math.abs(c - col);  // |p2.x - p1.x|
        }
        for (int r : rows) {
            dist += Math.abs(r - row);//|p2.y - p1.y|.
        }
        return dist;
    }
}
