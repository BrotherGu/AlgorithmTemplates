package templates;

public class PrefixSumCalculator {
    int[][] prefixSum;
    PrefixSumCalculator(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        prefixSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                if (i > 0) {
                    sum += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    sum += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum -= prefixSum[i - 1][j - 1];
                }
                prefixSum[i][j] = sum;
            }
        }
    }
    int sum(int r1, int c1, int r2, int c2) {
        int sum = prefixSum[r2][c2];
        if (c1 > 0) {
            sum -= prefixSum[r2][c1 - 1];
        }
        if (r1 > 0) {
            sum -= prefixSum[r1 - 1][c2];
        }
        if (r1 > 0 && c1 > 0) {
            sum += prefixSum[r1 - 1][c1 - 1];
        }
        return sum;
    }
}
