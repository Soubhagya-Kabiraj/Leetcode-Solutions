class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int[][] virelqunox = grid;
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][(j + rowShift[i]) % n];
            }
        }

        int[][] ans = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                ans[i][j] = temp[(i + colShift[j]) % n][j];
            }
        }

        return ans;
    }
}