/**
* 思路不难， 自己就想到了两种。但是对complexity的把握还需要提高。 bfs 
* 代码也不是很自信，细节的如同dist 要 init to what (0 is fine), and d init to be 1. etc.
* need to know how to choose these details
* spicific to this question: houseReached. 
* like what i drawed on the whiteboard, this method better for matrix sparse, O(numberOfHouses*m*n). if not sparse, tht intuitive way to traverse from available position and if reached all the house, compare the min distance mighe be better. O ((m*n)^2)
*/

class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int m = grid.length, n = grid[0].length;
        int[][] houseReached = new int[m][n];
        int[][] dist = new int[m][n];
        int buildingNum = 0;
        // for (int i = 0; i < m; i++) {Arrays.fill(dist[i], Integer.MAX_VALUE);}
         // bug : max + some number would be negative
        // can simply be init as 1 because chekced houseReached[i][j] == buildingNum, only valid cell with 0 can satisfy the condition
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // do a bfs to accumulate the minimum distance from each 0 position here
                    buildingNum ++;
                    int d = 1; // init to 1 as use it for neighbor with dist = 1
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int p = 0; p < size; p++) {
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int x = cur[0] + dir[k][0];
                                int y = cur[1] + dir[k][1];
                                if (x >= 0 && x < m && y >= 0 && y < n 
                                   && grid[x][y] == 0 && !visited[x][y]) {
                                    houseReached[x][y] ++;
                                    dist[x][y] += d;
                                    visited[x][y] = true;
                                    queue.offer(new int[]{x,y});
                                }
                            }
                        }
                        d++;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] < result && houseReached[i][j] == buildingNum) {
                    result = dist[i][j];
                } 
            }
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
